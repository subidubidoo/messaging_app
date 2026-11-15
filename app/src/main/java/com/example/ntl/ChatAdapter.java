package com.example.ntl;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;


// The adapter connects Java objects with XML design.
public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ChatViewHolder> {

    ArrayList<ChatMessage> messages;

    public ChatAdapter(ArrayList<ChatMessage> messages) {
        this.messages = messages;
    }

    @NonNull
    @Override
    public ChatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_message, parent, false);

        return new ChatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChatViewHolder holder, int position) {

        ChatMessage message = messages.get(position);

        holder.name.setText(message.getName());
        holder.message.setText(message.getMessage());
        holder.date.setText(message.getDate());
        holder.image.setImageResource(message.getImage());
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    public static class ChatViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView name, message, date;

        public ChatViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.imageView2);
            name = itemView.findViewById(R.id.textView2);
            message = itemView.findViewById(R.id.textView3);
            date = itemView.findViewById(R.id.textView4);
        }
    }
}