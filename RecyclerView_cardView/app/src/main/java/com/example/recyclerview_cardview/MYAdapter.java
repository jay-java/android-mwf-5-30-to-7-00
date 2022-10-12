package com.example.recyclerview_cardview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MYAdapter extends RecyclerView.Adapter<MyViewHolder> {
    ArrayList<Model> list;

    public MYAdapter(ArrayList<Model> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.single_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.imageView.setImageResource(list.get(position).getImg());
        holder.t1.setText(list.get(position).getName());
        holder.t2.setText(list.get(position).getChat());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
