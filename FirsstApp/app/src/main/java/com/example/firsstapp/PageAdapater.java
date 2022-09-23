package com.example.firsstapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PageAdapater extends FragmentPagerAdapter {
    int tabcount;
    public PageAdapater(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        tabcount = behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
       switch (position){
           case 0:return new Chat();
           case 1: return new Status();
           case 2: return new Call();
           default: return null;
       }
    }

    @Override
    public int getCount() {
        return tabcount;
    }
}
