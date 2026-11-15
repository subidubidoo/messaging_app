package com.example.ntl.modules;


import androidx.room.PrimaryKey;

import androidx.room.Entity;


@Entity(
        tableName = "Users")
public class Users {

    @PrimaryKey(autoGenerate = true)
    public int userId;
    public String userName;
    public String phoneNumber;
    public String email;
    public String password;



    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }}



