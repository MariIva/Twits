package com.example.twits;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import com.example.twits.DB.AppDB;
import com.example.twits.DB.Twit;
import com.example.twits.adapters.MyCardAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv;
    MyCardAdapter cardAdapter;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRecyclerView();
        fab = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Twit twit = Twit.generateTwit();
                cardAdapter.addItem(twit);
            }
        });

    }

    private void initRecyclerView() {
        rv = findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(
                this, GridLayoutManager.VERTICAL, false
        ));
        cardAdapter = new MyCardAdapter(this);
        cardAdapter.getList();
        rv.setAdapter(cardAdapter);
    }

}