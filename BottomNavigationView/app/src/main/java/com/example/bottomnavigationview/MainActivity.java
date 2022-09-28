package com.example.bottomnavigationview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view = findViewById(R.id.btn_id);
        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_id,new Home()).commit();
        view.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                Fragment fragment = null;
                switch(item.getItemId()){
                    case R.id.home_id:
                        fragment = new Home();
                        break;
                    case R.id.search_id:
                        fragment = new Search();
                        break;
                    case R.id.settings_id:
                        fragment = new Setting();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_id,fragment).commit();
            }

        });

    }
}