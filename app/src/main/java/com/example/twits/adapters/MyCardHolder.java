package com.example.twits.adapters;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.twits.R;

public class MyCardHolder extends RecyclerView .ViewHolder{

    TextView title;
    TextView text;
    TextView author;
    Button like;
    Button dislike;

    public MyCardHolder(@NonNull View itemView) {
        super(itemView);
        title = (TextView) itemView.findViewById(R.id.card_item_title);
        text = (TextView) itemView.findViewById(R.id.card_item_text);
        author = (TextView) itemView.findViewById(R.id.card_item_autor);
        like = (Button) itemView.findViewById(R.id.card_btn_like);
        dislike = (Button) itemView.findViewById(R.id.card_btn_dislike);
    }
}
