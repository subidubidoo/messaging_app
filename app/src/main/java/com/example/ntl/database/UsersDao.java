package com.example.ntl.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Upsert;

import com.example.ntl.modules.Users;

import java.util.List;

@Dao
public interface UsersDao {

    @Insert
    long insertUser(Users user);

    @Delete
    void deleteUser(Users user);

    @Query("SELECT * FROM Users " +
            "WHERE userName LIKE '%' || :search || '%' " +
            "OR phoneNumber LIKE '%' || :search || '%' " +
            "ORDER BY userName ASC")
    LiveData<List<Users>> searchUsers(String search);

    @Query("SELECT COUNT(*) FROM users WHERE email = :email OR phoneNumber = :phone")
    int countByEmailOrPhone(String email, String phone);
}