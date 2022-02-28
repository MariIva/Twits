package com.example.twits.DB;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Twit {
    @PrimaryKey(autoGenerate = true)
    private long id;
    public String title;
    public String text;
    public String author;
    public int like;
    public int dislike;

    @Ignore
    private static int count = 0;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public static Twit generateTwit(){
        Twit twit = new Twit();
        twit.title = "title " + count;
        twit.text = "text\ntext\ntext\ntext\ntext\n"+count;
        twit.author = "author"+count;
        count++;
        return twit;
    }
}
