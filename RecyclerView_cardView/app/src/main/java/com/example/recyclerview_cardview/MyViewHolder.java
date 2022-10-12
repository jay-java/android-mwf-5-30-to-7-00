package com.example.recyclerview_cardview;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {
    ImageView imageView;
    TextView t1,t2;
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.image_id);
        t1 = itemView.findViewById(R.id.name_text_id);
        t2 = itemView.findViewById(R.id.chat_id);
    }
}
