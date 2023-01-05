package com.example.relatingdata;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public  static final String artistName = "ARTIST_NAME";
    public  static final String artistId = "ARTIST_ID";
    EditText editText;
    Spinner spinner;
    Button button;
    DatabaseReference databaseReference;
    ListView listView;
    List<Artist> artistList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        databaseReference  = FirebaseDatabase.getInstance().getReference("artist");
        editText = findViewById(R.id.editText_id);
        spinner = findViewById(R.id.spinner_id);
        button = findViewById(R.id.btn_id);
        listView = findViewById(R.id.listView_id);
        artistList = new ArrayList<>();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addArtist();
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Artist artist = artistList.get(position);
                Intent intent = new Intent(MainActivity.this,AddTrack.class);
                intent.putExtra(artistId,artist.getId());
                intent.putExtra(artistName,artist.getName());
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                artistList.clear();
                for(DataSnapshot dataSnapshot:snapshot.getChildren()){
                    Artist artist = dataSnapshot.getValue(Artist.class);
                    artistList.add(artist);
                }
                ArrayAdapter arrayAdapter = new ArtistList(MainActivity.this,artistList);
                listView.setAdapter(arrayAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void addArtist(){
        String name = editText.getText().toString();
        String genre = spinner.getSelectedItem().toString();
        if(!TextUtils.isEmpty(name)){
            String pk = databaseReference.push().getKey();
            Artist artist = new Artist(pk,name,genre);
            databaseReference.child(pk).setValue(artist);
            Toast.makeText(this, "Artist added", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "enter name", Toast.LENGTH_SHORT).show();
        }
    }
}