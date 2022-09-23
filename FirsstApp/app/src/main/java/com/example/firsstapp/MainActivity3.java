package com.example.firsstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
    TextView t1,t2;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        t1 = findViewById(R.id.name_text_view);
        t2 = findViewById(R.id.pass_text);
        String name = getIntent().getStringExtra("name");
        String pas = getIntent().getStringExtra("pass");
        t1.setText(name);
        t2.setText(pas);
        button = findViewById(R.id.btn_id);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity3.this,MainActivity4.class));
            }
        });
    }
}