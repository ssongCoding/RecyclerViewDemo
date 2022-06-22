package com.example.recyclerviewdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<User> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
//        recyclerView.setHasFixedSize(true); // 이게 무슨 뜻이징; View 기존 성능 강화라는데..

        // 데이터 추가
        userList = new ArrayList<>(); // User 객체 담을 List --> 어댑터 줄거
        userList.add(new User("tester1", "테스터1"));
        userList.add(new User("tester2", "테스터2"));

        // Adapter에 데이터 전달(연결)
        adapter = new CustomAdapter(userList);
        recyclerView.setAdapter(adapter); // RecyclerView에 Adapter 연결
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }
}
