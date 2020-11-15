package com.example.tictactoedemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class playOnlineHost extends AppCompatActivity {
    private DatabaseReference OnlineRef;
    private RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_online_host);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        OnlineRef = FirebaseDatabase.getInstance().getReference().child("Online");
    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseRecyclerOptions<Online> options = new FirebaseRecyclerOptions.Builder<Online>().setQuery(OnlineRef,Online.class).build();
        FirebaseRecyclerAdapter<Online, UserAdapter> adapter = new FirebaseRecyclerAdapter<Online, UserAdapter>(options) {
            @Override
            protected void onBindViewHolder(@NonNull UserAdapter holder, int position, @NonNull final Online model) {
                holder.prdName.setText(model.getUsername());
                holder.prdEmail.setText(model.getEmail());
                holder.cardView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(playOnlineHost.this, playGame.class);
                        intent.putExtra("email",model.getEmail());
                        startActivity(intent);
                    }
                });
            }

            @NonNull
            @Override
            public UserAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hostlayout, parent,false);
                UserAdapter holder = new UserAdapter(view);
                return holder;
            }
        };
        recyclerView.setAdapter(adapter);
        adapter.startListening();
    }

}