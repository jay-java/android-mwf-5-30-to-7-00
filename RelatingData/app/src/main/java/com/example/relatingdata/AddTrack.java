package com.example.relatingdata;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class AddTrack extends AppCompatActivity {

    TextView textView;
    EditText editText;
    SeekBar seekBar;
    ListView listView;
    Button button;
    DatabaseReference databaseReference;
    List<Track> tracks;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_track);
        textView = findViewById(R.id.artistname_id);
        editText = findViewById(R.id.editTextTrack_id);
        seekBar  = findViewById(R.id.seekbaar_id);
        listView = findViewById(R.id.listView_id);
        tracks  =new ArrayList<>();
        button = findViewById(R.id.btn_id);
        Intent intent = getIntent();
        String id = intent.getStringExtra(MainActivity.artistId);
        String name = intent.getStringExtra(MainActivity.artistName);
        textView.setText(name);
        databaseReference = FirebaseDatabase.getInstance().getReference("track").child(id);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveTrack();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                tracks.clear();
                for(DataSnapshot trackSnapshot:snapshot.getChildren()){
                    Track track = trackSnapshot.getValue(Track.class);
                    tracks.add(track);
                }
                TrackList trackList = new TrackList(AddTrack.this,tracks);
                listView.setAdapter(trackList);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void saveTrack(){
        String trackName = editText.getText().toString().trim();
        int rating = seekBar.getProgress();
        if(!TextUtils.isEmpty(trackName)){
            String id = databaseReference.push().getKey();
            Track track = new Track(id,trackName,rating);
            databaseReference.child(id).setValue(track);
            Toast.makeText(this, "track added", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "track cannot be empty", Toast.LENGTH_SHORT).show();
        }
    }
}