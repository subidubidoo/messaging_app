package com.example.ntl.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.ntl.modules.Chats;

import java.util.List;

@Dao
public interface ChatsDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insertChat(Chats chat);

    // all chats for one user, newest first (for your chat list screen)
    @Query("SELECT * FROM Chats " +
            "WHERE user1Id = :userId OR user2Id = :userId " +
            "ORDER BY lastMessageSent DESC")
    LiveData<List<Chats>> getChatsForUser(int userId);

    // check if two users already have a chat
    @Query("SELECT * FROM Chats " +
            "WHERE (user1Id = :a AND user2Id = :b) " +
            "OR (user1Id = :b AND user2Id = :a) " +
            "LIMIT 1")
    Chats getChatBetween(int a, int b);

    // get one chat by id
    @Query("SELECT * FROM Chats WHERE chatId = :chatId")
    Chats getChatById(long chatId);

    // bump the chat to the top when a new message arrives
    @Query("UPDATE Chats SET lastMessageSent = :time WHERE chatId = :chatId")
    void updateLastMessageTime(long chatId, long time);

    @Delete
    void deleteChat(Chats chat);
}
