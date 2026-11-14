package com.example.ntl;

import androidx.room.Database;
import androidx.room.RoomDatabase;
@Database(
        entities = {Users.class},
        version = 1
)
abstract class UsersDatabase extends RoomDatabase {
    public abstract UsersDao usersDao();
}
