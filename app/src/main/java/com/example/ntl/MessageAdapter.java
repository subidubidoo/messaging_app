package com.example.ntl;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ntl.modules.Messages;

import java.util.ArrayList;
import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageViewHolder> {

    private List<Messages> messages = new ArrayList<>();

    // call this whenever the list of messages changes
    public void setMessages(List<Messages> newMessages) {
        messages = newMessages;
        notifyDataSetChanged();
    }

    // makes one empty bubble (from item_message.xml)
    @NonNull
    @Override
    public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_message, parent, false);
        return new MessageViewHolder(view);
    }

    // fills a bubble with the text of the message at this position
    @Override
    public void onBindViewHolder(@NonNull MessageViewHolder holder, int position) {
        holder.messageTv.setText(messages.get(position).message_text);
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    static class MessageViewHolder extends RecyclerView.ViewHolder {
        TextView messageTv;

        MessageViewHolder(@NonNull View itemView) {
            super(itemView);
            messageTv = itemView.findViewById(R.id.messageTv);
        }
    }
}
