package com.example.tictactoedemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class gameMainPage extends AppCompatActivity {
    private Button pc, online, friends,exit,profile;
    FirebaseUser user;
    String userID;
    private DatabaseReference reference;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_main_page);

        mAuth = FirebaseAuth.getInstance();
        user = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Users");
        userID = user.getUid();

        reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User profile = snapshot.getValue(User.class);
                if(profile != null){
                    User user = new User();
                    user.status = true;
                    reference.child(userID).child("status").setValue(user.status);
                    String names = profile.getUsername();
                    String emails = profile.getEmail();

                    Online onuser = new Online(names,emails);
                    FirebaseDatabase.getInstance().getReference("Online").
                            child(FirebaseAuth.getInstance().getCurrentUser().getUid()).
                            setValue(onuser).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                        }
                    });
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(gameMainPage.this, "Something went wrong. Restart the app.", Toast.LENGTH_SHORT).show();

            }
        });

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