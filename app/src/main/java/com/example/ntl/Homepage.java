package com.example.ntl;

import android.os.Bundle;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Homepage extends AppCompatActivity {
    RecyclerView messagesRecyclerView;
    ArrayList<ChatMessage> messages;
    ChatAdapter chatAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_homepage);
        // find the recycler view in the layout
        messagesRecyclerView = findViewById(R.id.messagesRecyclerView);
        //Create an empty list to store messages
        messages = new ArrayList<>();

        // Add test messages
        messages.add(new ChatMessage(
                "Ahmad",
                "Hello! How are you?",
                "10:30 AM",
                R.drawable.boy
        ));

        messages.add(new ChatMessage(
                "Sara",
                "How is your project going?",
                "Yesterday",
                R.drawable.girl
        ));
        messages.add(new ChatMessage(
                "Mariam",
                "كيف حالك؟؟",
                "Todat at 3:30 pm",
                R.drawable.girl
        ));
        messages.add(new ChatMessage(
                "Haya",
                "I miss you!!",
                "3 min ago",
                R.drawable.girl
        ));
        messages.add(new ChatMessage(
                "Tameem",
                "Did you finish the project?",
                "Todat at 9 am",
                R.drawable.boy
        ));
        messages.add(new ChatMessage(
                "Ali",
                "Dont forget our meeting today at 4 pm",
                "Todat at 10 am",
                R.drawable.boy
        ));
        messages.add(new ChatMessage(
                "Noor",
                "let's eat sushi tonight",
                "10 min ago",
                R.drawable.girl
        ));
        messages.add(new ChatMessage(
                "Dr. Mohammad",
                "Don't forget the assignment!!",
                "Todat at 9 am",
                R.drawable.boy
        ));

        // 	Passes the messages to the adapter
        chatAdapter = new ChatAdapter(messages);
        // set the layout manager and adapter for the recycler view
        // Displays messages vertically
        messagesRecyclerView.setLayoutManager(
                new LinearLayoutManager(this)
        );
        // Connect the adapter to RecyclerView
        messagesRecyclerView.setAdapter(chatAdapter);



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


    }
}