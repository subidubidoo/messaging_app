package com.example.ntl.modules;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "Messages",
foreignKeys = {
        @ForeignKey(
                entity = Users.class,
                parentColumns = "userId",
                childColumns = "senderId",
                onDelete = ForeignKey.CASCADE),
        @ForeignKey(
                entity = Chats.class,
                parentColumns = "chatId",
                childColumns = "chatMessageId",
                onDelete = ForeignKey.CASCADE
        )

        },
        indices = {
                @Index("chatMessageId"),
                @Index("senderId")
        })
public class Messages {
    @PrimaryKey(autoGenerate = true)
    public int messageId =0;
    public int senderId;
    public String message_text;
    public long messageSentDate;
    public int chatMessageId;

}
