package com.example.twits.DB;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Twit.class}, version = 1)
public abstract class AppDB extends RoomDatabase {
    public abstract TwitDao twitDao();
}
