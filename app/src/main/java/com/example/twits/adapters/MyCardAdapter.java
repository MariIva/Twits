package com.example.twits.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.twits.DB.AppDB;
import com.example.twits.DB.Twit;
import com.example.twits.R;

import java.util.ArrayList;
import java.util.List;

public class MyCardAdapter extends RecyclerView.Adapter<MyCardHolder> {

    List<Twit> list = new ArrayList<>();
    Context context;

    private AppDB database;

    public MyCardAdapter(Context context) {
        this.context = context;
        database = Room.databaseBuilder(context, AppDB.class, "database")
                .build();
        getList();
    }

    @NonNull
    @Override
    public MyCardHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rv_card_item, parent, false);
        return new MyCardHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyCardHolder holder, int position) {
        Twit twit = list.get(position);

        holder.title.setText(twit.title);
        holder.text.setText(twit.text);
        holder.author.setText(twit.author);
        holder.like.setText(twit.like+"");
        holder.dislike.setText(twit.dislike+"");
        holder.like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                twit.like++;
                holder.like.setText(twit.like+"");
                updateItem(twit);
            }
        });
        holder.dislike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                twit.dislike++;
                holder.dislike.setText(twit.dislike+"");
                updateItem(twit);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void getList(){
        Thread thread = new Thread(new Runnable() {
            public void run() {
                List<Twit> twits = database.twitDao().getAll();
                list = twits;
            }
        });
        thread.start();
    }

    public void addItem(Twit twit){
        list.add(twit);
        notifyDataSetChanged();
        Thread thread = new Thread(new Runnable() {
            public void run() {
                database.twitDao().insert(twit);
            }
        });
        thread.start();
    }

    private void updateItem(Twit twit){
        Thread thread = new Thread(new Runnable() {
            public void run() {
                database.twitDao().update(twit);
            }
        });
        thread.start();
    }
}
