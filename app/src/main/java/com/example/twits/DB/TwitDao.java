package com.example.twits.DB;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface TwitDao {

    @Query("SELECT * FROM Twit")
    List<Twit> getAll();

    @Insert
    void insert(Twit twit);

    @Update
    void update(Twit twit);
}
