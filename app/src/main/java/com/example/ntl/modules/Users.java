package com.example.ntl.modules;

import androidx.room.ForeignKey;
import androidx.room3.PrimaryKey;
import java.sql.Date;
import androidx.room.Entity;


@Entity(
        tableName = "Users")
public class Users {

    @PrimaryKey(autoGenerate = true)
    public int userId;
    public String userName;
    public String phoneNumber;
    private String email;
    private String password;
    private Date dateOfBirth;


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
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }
}

