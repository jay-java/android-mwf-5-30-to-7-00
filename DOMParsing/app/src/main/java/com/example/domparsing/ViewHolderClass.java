package com.example.domparsing;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolderClass extends RecyclerView.ViewHolder {
    TextView name1,mobile1,course1;
    public ViewHolderClass(@NonNull View itemView) {
        super(itemView);
        name1=itemView.findViewById(R.id.name_c_id);
        mobile1=itemView.findViewById(R.id.mobile_c_id);
        course1=itemView.findViewById(R.id.course_c_id);
    }
}
