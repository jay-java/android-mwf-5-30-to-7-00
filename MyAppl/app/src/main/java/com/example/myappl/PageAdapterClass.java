package com.example.myappl;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
public class PageAdapterClass extends FragmentPagerAdapter {
    int tabcount;
    public PageAdapterClass(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        tabcount = behavior;
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:return new Tab1();
            case 1:return new Tab2();
            case 2:return new Tab3();
            default:return null;
        }
    }
    @Override
    public int getCount() {
        return tabcount;
    }
}
