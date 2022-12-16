package com.example.retrofitdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    String url = "https://jsonplaceholder.typicode.com/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.tv);

        textView.setText("");
        //1. retrofit object
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                //2.json to GSON object
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //3.call of api reference
        API a = retrofit.create(API.class);
        Call<List<Model>> list = a.getAllModel();
        list.enqueue(new Callback<List<Model>>() {
            @Override

            //4. response objectc from retrofit list api
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {
                List<Model> list = response.body();
                for(int i =0;i<list.size();i++){
                    textView.append("id : "+list.get(i).getId()+" \n " +" title : "+list.get(i).getTitle()+"\n\n");
                }
            }
            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}