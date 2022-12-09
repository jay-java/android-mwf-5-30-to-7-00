package com.example.domparsing;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class RecleryAdapterClass extends RecyclerView.Adapter<ViewHolderClass> {
    ArrayList<model> slist = new ArrayList<>();

    public RecleryAdapterClass(ArrayList<model> slist) {
        this.slist = slist;
    }

    @NonNull
    @Override
    public ViewHolderClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.single_raw, parent, false);
        return new ViewHolderClass(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderClass holder, int position) {
        holder.name1.setText(slist.get(position).getName());
        holder.course1.setText(slist.get(position).getCourse());
        holder.mobile1.setText(slist.get(position).getMobile());


    }

    @Override
    public int getItemCount() {
        return slist.size();
    }
}
