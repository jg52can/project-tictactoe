package com.example.tictactoedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Thread mythread = new Thread(){
            @Override
            public void run() {
              try{
                  sleep(3000);
                  Intent intent = new Intent(getApplicationContext(),login.class);
                  startActivity(intent);
                  finish();
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
            }
        };mythread.start();
    }
}