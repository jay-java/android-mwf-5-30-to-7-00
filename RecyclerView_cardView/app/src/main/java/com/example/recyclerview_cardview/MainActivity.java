package com.example.recyclerview_cardview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Display;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    MYAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyler_id);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        myAdapter = new MYAdapter(getAllData());
        recyclerView.setAdapter(myAdapter);

    }
    public ArrayList<Model> getAllData(){
        ArrayList<Model> list = new ArrayList<>();

        Model m1 = new Model();
        m1.setImg(R.mipmap.ic_launcher);
        m1.setName("Nirav");
        m1.setChat("Hi");
        list.add(m1);


        Model m2 = new Model();
        m2.setImg(R.mipmap.ic_launcher);
        m2.setName("Shehjad");
        m2.setChat("Hi");
        list.add(m2);

        Model m3 = new Model();
        m3.setImg(R.mipmap.ic_launcher);
        m3.setName("LAlit");
        m3.setChat("Hi");
        list.add(m3);

        Model m4 = new Model();
        m4.setImg(R.mipmap.ic_launcher);
        m4.setName("Pro");
        m4.setChat("Hi");
        list.add(m4);

        Model m5 = new Model();
        m5.setImg(R.mipmap.ic_launcher);
        m5.setName("Anshu");
        m5.setChat("Hi");
        list.add(m5);

        return list;
    }
}