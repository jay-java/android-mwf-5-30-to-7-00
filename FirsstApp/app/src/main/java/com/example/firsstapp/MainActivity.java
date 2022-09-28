package com.example.firsstapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    TabItem t1,t2,t3;
    ViewPager viewPager;
    PageAdapater pageAdapater;
    Button button,okaybtn;
    Spinner spinner;
    CarAdapter carAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner_id);
        carAdapter = new CarAdapter(MainActivity.this,Data.getAllCar());
        spinner.setAdapter(carAdapter);


        button = findViewById(R.id.btn_id);

        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.custom_dialogue);
        okaybtn = dialog.findViewById(R.id.okay_id);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();
                dialog.setCancelable(false);

//                LayoutInflater layoutInflater = getLayoutInflater();
//                View view1 = layoutInflater.inflate(R.layout.custom_toast,(ViewGroup)findViewById(R.id.custo_id));
//
//                Toast toast = new Toast(getApplicationContext());
//                toast.setView(view1);
//                toast.setDuration(Toast.LENGTH_LONG);
//                toast.setGravity(Gravity.BOTTOM,0,100);
//                toast.show();
            }
        });

        okaybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });


        tabLayout = findViewById(R.id.tablyaout_id);
        t1 = findViewById(R.id.tab1);
        t2 = findViewById(R.id.tab2);
        t3 = findViewById(R.id.tab3);
        viewPager  =findViewById(R.id.viewPager_id);
        pageAdapater = new PageAdapater(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(pageAdapater);
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if(tab.getPosition()==0||tab.getPosition()==1||tab.getPosition()==2){
                    viewPager.setCurrentItem(tab.getPosition());
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }
}