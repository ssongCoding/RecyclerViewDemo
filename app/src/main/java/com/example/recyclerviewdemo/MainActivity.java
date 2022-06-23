package com.example.recyclerviewdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<User> userList;

    /*** ***/
    private UserDao userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /***  ***/
        UserDatabase database = Room.databaseBuilder(getApplicationContext(), UserDatabase.class, "RoomDBTest")
                .fallbackToDestructiveMigration() // 스키마(Database) 버전 변경 가능
                .allowMainThreadQueries()         // Main Thread에서 IO(Input/Output)들(=쿼리) 가능하게 함.
                .build();

        userDao = database.userDao();             // 인터페이스 객체 할당

//        User user = new User("songa1", "송아1");
//        User user2 = new User("songa2", "송아2");
//        userDao.setInsertUser(user);
//        userDao.setInsertUser(user2);
        /***  ***/

        recyclerView = findViewById(R.id.recyclerView);
//        recyclerView.setHasFixedSize(true); // 이게 무슨 뜻이징; View 기존 성능 강화라는데..

        // 데이터 추가
        userList = new ArrayList<>(); // User 객체 담을 List --> 어댑터 줄거
//        userList.add(new User("tester1", "테스터1"));
//        userList.add(new User("tester2", "테스터2"));
        for (int i = 0; i<userDao.getUserAll().size(); i++){
            userList.add(userDao.getUserAll().get(i));
        }

        // Adapter에 데이터 전달(연결)
        adapter = new CustomAdapter(userList);
        recyclerView.setAdapter(adapter); // RecyclerView에 Adapter 연결
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        /*** Click ***/
        recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
                if(e.getAction() == MotionEvent.ACTION_DOWN){
                    View child = rv.findChildViewUnder(e.getX(), e.getY());
                    TextView tv = rv.getChildViewHolder(child).itemView.findViewById(R.id.tv_userName);
                    Toast.makeText(getApplicationContext(), tv.getText(), Toast.LENGTH_SHORT).show();
                }
                return false;
            }

            @Override
            public void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });

    }
}
