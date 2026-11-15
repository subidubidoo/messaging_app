package com.example.ntl.modules;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(
        tableName = "Chats",
        foreignKeys = {
                @ForeignKey(
                        entity = Users.class,
                        parentColumns = "userId",
                        childColumns = "user1Id",
                        onDelete = ForeignKey.CASCADE
                ),
                @ForeignKey(
                        entity = Users.class,
                        parentColumns = "userId",
                        childColumns = "user2Id",
                        onDelete = ForeignKey.CASCADE
                )
        },
        indices = {
                @Index(value = {"user1Id","user2Id"}, unique = true),
                @Index("user2Id")
        }
)
public class Chats {
    @PrimaryKey (autoGenerate = true)
    public int chatId =0;

    public int user1Id;
    public int user2Id;
    public long lastMessageSent;


}
