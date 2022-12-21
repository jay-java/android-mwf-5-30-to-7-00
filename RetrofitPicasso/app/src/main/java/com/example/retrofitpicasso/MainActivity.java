package com.example.retrofitpicasso;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imageView = findViewById(R.id.image_view);

        String url = "https://cdn.pixabay.com/photo/2017/11/06/18/39/apple-2924531_960_720.jpg";

        Picasso.with(this).load(url).into(imageView);
    }
}