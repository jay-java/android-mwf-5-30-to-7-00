package com.example.navigationdrawerdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    NavigationView view;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar  =findViewById(R.id.toolbar_id);
        setSupportActionBar(toolbar);
        view = findViewById(R.id.navigationDrawer_id);

        drawerLayout = findViewById(R.id.drawerlayout_id);
        drawerLayout.setDrawerListener(toggle);
        toggle  =new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        toggle.syncState();
        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_id,new Home()).commit();
        view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                switch (item.getItemId()){
                    case R.id.home_id:
                        fragment  =new Home();
                        break;
                    case R.id.setting_id:
                        fragment = new Setting();
                        break;
                    case R.id.logine_id:
                        fragment  =new Login();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_id,fragment).commit();
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }
}