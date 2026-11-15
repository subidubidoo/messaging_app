package com.example.ntl.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.ntl.modules.Chats;
import com.example.ntl.modules.Messages;
import com.example.ntl.modules.Users;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(
        entities = {Users.class, Chats.class, Messages.class},
        version = 3
)
public abstract class UsersDatabase extends RoomDatabase {
    public abstract UsersDao usersDao();
    public abstract ChatsDao chatDao();
    public abstract MessagesDao messageDao();

    private static volatile UsersDatabase INSTANCE;
    public static final ExecutorService databaseExecutor =
            Executors.newFixedThreadPool(4);

    public static UsersDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (UsersDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(),
                            UsersDatabase.class,
                            "app_database"
                    ).fallbackToDestructiveMigration().build();
                }
            }
        }
        return INSTANCE;
    }
}
