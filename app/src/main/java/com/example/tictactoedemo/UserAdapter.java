package com.example.tictactoedemo;


import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView prdName, prdEmail;
    itemCLickListener listener;
    CardView cardView;
    public UserAdapter(@NonNull View itemView) {
        super(itemView);
        prdName = (TextView) itemView.findViewById(R.id.txtUserName);
        prdEmail = (TextView) itemView.findViewById(R.id.txtUserEmail);
        cardView = (CardView)itemView.findViewById(R.id.cardView11);
    }
    public void setItemClickListener(itemCLickListener listener){
        this.listener= listener;
    }
    @Override
    public void onClick(View v) {
        listener.onClick(v, getAdapterPosition(), false);
    }
}

