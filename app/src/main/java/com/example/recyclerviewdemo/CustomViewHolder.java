package com.example.recyclerviewdemo;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CustomViewHolder extends RecyclerView.ViewHolder {

    ImageView iv_profile;
    TextView tv_id, tv_userName;

    public CustomViewHolder(@NonNull View itemView) {
        super(itemView);

        this.iv_profile = itemView.findViewById(R.id.iv_profile);
        this.tv_id = itemView.findViewById(R.id.tv_id);
        this.tv_userName = itemView.findViewById(R.id.tv_userName);
    }
}
