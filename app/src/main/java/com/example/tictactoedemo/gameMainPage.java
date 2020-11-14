package com.example.tictactoedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class gameMainPage extends AppCompatActivity {
    private Button pc, online, friends,exit,profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_main_page);

        pc  = (Button) findViewById(R.id.btn_user_computer);
        online  = (Button) findViewById(R.id.btn_user_play_online);
        friends  = (Button) findViewById(R.id.btn_user_play_with_friends);
        exit  = (Button) findViewById(R.id.btn_user_exit);
        profile  = (Button) findViewById(R.id.btn_user_profile);

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(gameMainPage.this,userProfile.class));
                finish();
            }
        });
        pc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(gameMainPage.this,playWithComputer.class));
                finish();
            }
        });

        online.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(gameMainPage.this,playOnline.class));
                finish();
            }
        });

        friends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(gameMainPage.this,playWithFriend.class));
                finish();
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}