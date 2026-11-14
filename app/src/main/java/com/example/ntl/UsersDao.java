package com.example.ntl;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Query;
import androidx.room.Upsert;

import java.util.List;

@Dao
public interface UsersDao {

    @Upsert
    void upsertUser(Users user);

    @Delete
    void deleteUser(Users user);

    @Query("SELECT * FROM Users " +
            "WHERE userName LIKE '%' || :search || '%' " +
            "OR phoneNumber LIKE '%' || :search || '%' " +
            "ORDER BY userName ASC")
    LiveData<List<Users>> searchUsers(String search);
}