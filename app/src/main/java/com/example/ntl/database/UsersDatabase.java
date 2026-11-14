package com.example.ntl.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.ntl.modules.Chats;
import com.example.ntl.modules.Messages;
import com.example.ntl.modules.Users;

@Database(
        entities = {Users.class, Chats.class, Messages.class},
        version = 3
)
abstract class UsersDatabase extends RoomDatabase {
    public abstract UsersDao usersDao();
    public abstract ChatsDao chatDao();
    public abstract MessagesDao messageDao();
}
