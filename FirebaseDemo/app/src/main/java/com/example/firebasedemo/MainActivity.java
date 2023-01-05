package com.example.firebasedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    EditText nameED,contactED,addressED,emailED,passwordED;
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameED = findViewById(R.id.name_id);
        contactED = findViewById(R.id.contact_id);
        addressED = findViewById(R.id.address_id);
        emailED = findViewById(R.id.email_id);
        passwordED = findViewById(R.id.pass_id);
        submit = findViewById(R.id.btn_id);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameED.getText().toString();
                String contact = contactED.getText().toString();
                String address = addressED.getText().toString();
                String email = emailED.getText().toString();
                String pass = passwordED.getText().toString();
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("users");
                String id = myRef.push().getKey();
                Data d = new Data(id,name,contact,address,email,pass);
                myRef.child(id).setValue(d);
                Toast.makeText(MainActivity.this, "data stored", Toast.LENGTH_SHORT).show();
                nameED.setText("");
                contactED.setText("");
                addressED.setText("");
                emailED.setText("");
                passwordED.setText("");
            }
        });


    }
}