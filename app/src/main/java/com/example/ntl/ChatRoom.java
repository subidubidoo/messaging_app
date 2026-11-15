package com.example.ntl;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ntl.database.UsersDatabase;
import com.example.ntl.modules.Chats;
import com.example.ntl.modules.Messages;

public class ChatRoom extends AppCompatActivity {

    private UsersDatabase db;
    private MessageAdapter adapter;
    private RecyclerView messagesRv;
    private EditText messageInput;

    private int currentUserId;
    private int chatId = -1;   // stays -1 until the chat is ready

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_chat_room);

        // keeps the screen clear of the status bar and lifts the text box above the keyboard
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets bars = insets.getInsets(
                    WindowInsetsCompat.Type.systemBars() | WindowInsetsCompat.Type.ime());
            v.setPadding(bars.left, bars.top, bars.right, bars.bottom);
            return insets;
        });

        db = UsersDatabase.getInstance(this);
        currentUserId = getSharedPreferences("session", MODE_PRIVATE).getInt("userId", -1);

        TextView chatNameTv = findViewById(R.id.chatNameTv);
        messagesRv = findViewById(R.id.messagesRv);
        messageInput = findViewById(R.id.messageInput);
        Button sendBt = findViewById(R.id.sendBt);

        // the name on top (later, the chat list will pass the real name in)
        String otherName = getIntent().getStringExtra("otherName");
        chatNameTv.setText(otherName != null ? otherName : "Me");

        adapter = new MessageAdapter();
        messagesRv.setLayoutManager(new LinearLayoutManager(this));
        messagesRv.setAdapter(adapter);

        // nobody logged in = no user to send as
        if (currentUserId == -1) {
            Toast.makeText(this, "Log in first", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        setUpChat();
        sendBt.setOnClickListener(v -> sendMessage());
    }

    private void setUpChat() {
        UsersDatabase.databaseExecutor.execute(() -> {
            // the other person doesn't exist yet, so for now the chat is with yourself
            Chats chat = db.chatDao().getChatBetween(currentUserId, currentUserId);
            if (chat == null) {
                Chats newChat = new Chats();
                newChat.user1Id = currentUserId;
                newChat.user2Id = currentUserId;
                newChat.lastMessageSent = System.currentTimeMillis();
                db.chatDao().insertChat(newChat);
                chat = db.chatDao().getChatBetween(currentUserId, currentUserId);
            }
            final int readyChatId = chat.chatId;

            runOnUiThread(() -> {
                chatId = readyChatId;

                // the list updates by itself every time a message is saved
                db.messageDao().getMessagesForChat(chatId).observe(this, list -> {
                    adapter.setMessages(list);
                    if (!list.isEmpty()) {
                        messagesRv.scrollToPosition(list.size() - 1);
                    }
                });
            });
        });
    }

    private void sendMessage() {
        String text = messageInput.getText().toString().trim();
        if (text.isEmpty() || chatId == -1) return;

        messageInput.setText("");

        Messages message = new Messages();
        message.senderId = currentUserId;
        message.message_text = text;
        message.messageSentDate = System.currentTimeMillis();
        message.chatMessageId = chatId;

        UsersDatabase.databaseExecutor.execute(() -> {
            db.messageDao().insertMessage(message);
            db.chatDao().updateLastMessageTime(message.chatMessageId, message.messageSentDate);
        });
    }
}