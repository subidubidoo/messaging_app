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
                @Index("chatId"),
                @Index("senderId")
        })
public class Messages {
    @PrimaryKey(autoGenerate = true)
    private int messageId =0;
    private int senderId;
    String message_text;
    private Date messageSentDate;
    private int chatMessageId;

}
