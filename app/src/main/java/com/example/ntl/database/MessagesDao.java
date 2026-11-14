package com.example.ntl.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.ntl.modules.Messages;

import java.util.List;

@Dao
public interface MessagesDao {
    @Insert
    long insertMessage(Messages message);

    @Delete
    void deleteMessage(Messages message);

    @Query("SELECT * FROM Messages WHERE chatMessageId = :chatId ORDER BY messageSentDate ASC")
    LiveData<List<Messages>> getMessagesForChat(long chatId);


}
