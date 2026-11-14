package com.example.ntl;

import androidx.room3.PrimaryKey;
import java.sql.Date;
import androidx.room.Entity;


@Entity(tableName = "Users")
public class Users {

    @PrimaryKey(autoGenerate = true)
    public int userId;
    public String userName;
    public String phoneNumber;
    private String email;
    private String password;
    private Date dateOfBirth;


}

