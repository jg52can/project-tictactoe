package com.example.tictactoedemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class userProfile extends AppCompatActivity {
    private Button back,signout;
    private FirebaseUser user;
    private DatabaseReference reference;

    private String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        back  = (Button) findViewById(R.id.btn_profile_back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(userProfile.this,gameMainPage.class));
                finish();
            }
        });

        signout = (Button)findViewById(R.id.btnSignOut);
        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(userProfile.this, MainActivity.class));
                finish();
            }
        });

        user = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Users");
        userID = user.getUid();

        final TextView fname = (TextView)findViewById(R.id.txtName);
        final TextView femail = (TextView)findViewById(R.id.txtEmail);
        final TextView fuser = (TextView)findViewById(R.id.txtusernamee);
        final TextView win = (TextView)findViewById(R.id.txtwinnumber);
        final TextView lose = (TextView)findViewById(R.id.txtlosenumber);

        reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User profile = snapshot.getValue(User.class);
                if(profile != null){
                    String fullName = profile.getFullname();
                    String email = profile.getEmail();
                    String username = profile.getUsername();
                    String wins = String.valueOf(profile.getWin());
                    String loses = String.valueOf(profile.getLose());
                    fname.setText(fullName);
                    femail.setText(email);
                    fuser.setText(username);
                    win.setText(wins);
                    lose.setText(loses);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(userProfile.this, "Something went wrong. Restart the app.", Toast.LENGTH_SHORT).show();

            }
        });

    }
}