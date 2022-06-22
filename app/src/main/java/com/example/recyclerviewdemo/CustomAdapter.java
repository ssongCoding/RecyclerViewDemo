package com.example.recyclerviewdemo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * 핵심!
 * list_item(아이템 레이아웃)에 데이터(는 메인에서 받을 예정)를 연결해줄 어댑터
 */
public class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder> {

    private List<User> userList;

    // 메인에서 Adapter 생성할 때, 데이터 값 줄거임.
    public CustomAdapter(List<User> userInfo) {
        this.userList = userInfo;
    }

    // 1) Holder 생성
    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        CustomViewHolder holder = new CustomViewHolder(view);
        return holder;
    }

    // 2) RecylerView가 어댑터를 통해서 하는 일 중 가장 중요한 일!
    // Holder랑 데이터를 연결해줌.
    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.tv_id.setText(userList.get(position).getId());
        holder.tv_userName.setText(userList.get(position).getUserName());
    }

    @Override
    public int getItemCount() {
        return (userList != null ? userList.size() : 0);
    }
}
