package com.example.firsstapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CarAdapter extends BaseAdapter {
    private Context context;
    private List<Car> carList;

    public CarAdapter(Context context, List<Car> carList) {
        this.context = context;
        this.carList = carList;
    }

    @Override
    public int getCount() {
        return carList !=null ? carList.size():0;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View rootView = LayoutInflater.from(context).inflate(R.layout.item_car,viewGroup,false);

        TextView textView = rootView.findViewById(R.id.text_id);
        ImageView imageView = rootView.findViewById(R.id.image_id);

        textView.setText(carList.get(i).getName());
        imageView.setImageResource(carList.get(i).getImage());
        return rootView;
    }
}
