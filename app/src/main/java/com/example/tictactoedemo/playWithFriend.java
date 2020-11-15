package com.example.tictactoedemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Random;

public class playWithFriend extends AppCompatActivity {
    FirebaseUser user;
    String userID;
    private DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_with_friend);
        user = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Users");
        userID = user.getUid();

        reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User profile = snapshot.getValue(User.class);
                if(profile != null){
                    String fullName = profile.fullname;
                    String email = profile.email;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(playWithFriend.this, "Something went wrong. Restart the app.", Toast.LENGTH_SHORT).show();

            }
        });


    }

    public void buClick(View view) {
        Button buSelected=(Button) view;
        int cellId=0;
        switch(buSelected.getId()){
            case R.id.button:
                cellId=1;
                break;
            case R.id.button2:
                cellId=2;
                break;
            case R.id.button3:
                cellId=3;
                break;
            case R.id.button4:
                cellId=4;
                break;
            case R.id.button5:
                cellId=5;
                break;
            case R.id.button6:
                cellId=6;
                break;
            case R.id.button7:
                cellId=7;
                break;
            case R.id.button8:
                cellId=8;
                break;
            case R.id.button9:
                cellId=9;
                break;
        }
        playGame(cellId,buSelected);
    }
    boolean single=false;
    int active_player=1;
    ArrayList<Integer> Player1=new ArrayList<Integer>();
    ArrayList<Integer> Player2=new ArrayList<Integer>();
    void playGame(int cellId,Button button){
        Log.d( "Player:",String.valueOf(cellId));
        if(active_player==1){
            button.setBackgroundResource(R.drawable.x);
            Player1.add(cellId);
            active_player=2;
            if(single)
                AutoPlay();
        }
        else if(active_player==2){
            button.setBackgroundResource(R.drawable.o);
            Player2.add(cellId);
            active_player=1;
        }
        button.setEnabled(false);
        checkWin();
    }


    void AutoPlay(){

        ArrayList<Integer> EmptyCells= new ArrayList<Integer>();

        for (int cellID=1; cellID<10;cellID++){
            if (!( Player1.contains(cellID) || Player2.contains(cellID))){
                EmptyCells.add(cellID);
            }
        }

        Random r= new Random();
        int  RandIndex=r.nextInt(EmptyCells.size()- 0)+ 0;
        int CellID=EmptyCells.get(RandIndex);

        Button buSelected;
        switch (CellID){

            case 1 :
                buSelected=(Button) findViewById(R.id.button);
                break;

            case 2:
                buSelected=(Button) findViewById(R.id.button2);
                break;

            case 3:
                buSelected=(Button) findViewById(R.id.button3);
                break;

            case 4:
                buSelected=(Button) findViewById(R.id.button4);
                break;

            case 5:
                buSelected=(Button) findViewById(R.id.button5);
                break;

            case 6:
                buSelected=(Button) findViewById(R.id.button6);
                break;

            case 7:
                buSelected=(Button) findViewById(R.id.button7);
                break;

            case 8:
                buSelected=(Button) findViewById(R.id.button8);
                break;

            case 9:
                buSelected=(Button) findViewById(R.id.button9);
                break;
            default:
                buSelected=(Button) findViewById(R.id.button);
                break;

        }
        playGame(CellID, buSelected);
    }
    public void modeClick(View view) {
        single=true;
    }

}