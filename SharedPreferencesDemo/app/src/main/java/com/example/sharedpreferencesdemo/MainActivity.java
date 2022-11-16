package com.example.sharedpreferencesdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText t1,t2;
    Button b1,b2;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t1 = findViewById(R.id.name_id);
        t2 = findViewById(R.id.password_id);
        b1= findViewById(R.id.save_id);
        b2 = findViewById(R.id.logout_id);
        tv = findViewById(R.id.tv_id);
        checkExistData();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sp  =getSharedPreferences("authentication",MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("name",t1.getText().toString());
                editor.putString("password",t2.getText().toString());
                editor.apply();
                t1.setText("");
                t2.setText("");
                tv.setTextColor(Color.GREEN);
                tv.setText("data stored successfully");
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sp  =getSharedPreferences("authentication",MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.clear();
                editor.apply();
                t1.setText("");
                t2.setText("");
                tv.setTextColor(Color.GREEN);
                tv.setText("Logout done");
            }
        });
    }

    public void checkExistData() {
        SharedPreferences sp  =getSharedPreferences("authentication",MODE_PRIVATE);
        if(sp.contains("name")){
            t1.setText(sp.getString("name",""));
            t2.setText(sp.getString("password",""));
        }
        else{
            tv.setText("data not found");
            tv.setTextColor(Color.RED);
        }
    }
}