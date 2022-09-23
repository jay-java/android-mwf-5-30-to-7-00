package com.example.firsstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    EditText e1,e2;
    Button b1;
    CheckBox checkBox;
    RadioGroup radioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        e1 = findViewById(R.id.name_id);
        e2 = findViewById(R.id.pass_id);
        b1=  findViewById(R.id.submit_id);
        checkBox = findViewById(R.id.check_id);

        radioGroup  =findViewById(R.id.radiogroup_id);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.male_id:
                        Toast.makeText(MainActivity2.this, "Male", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.female_id:
                        Toast.makeText(MainActivity2.this, "Female", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    Toast.makeText(MainActivity2.this, "Checked", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity2.this, "Unchecked", Toast.LENGTH_SHORT).show();
                }
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = e1.getText().toString();
                String password = e2.getText().toString();
                Intent i = new Intent(MainActivity2.this,MainActivity3.class);
                i.putExtra("name", name);
                i.putExtra("pass", password);
                startActivity(i);
            }
        });
    }
}