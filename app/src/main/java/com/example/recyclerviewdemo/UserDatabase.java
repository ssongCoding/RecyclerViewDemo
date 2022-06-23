package com.example.recyclerviewdemo;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities =  {User.class}, version = 1) // version : 변경 사항 관리하려고 (ex. col 추가)
public abstract class UserDatabase extends RoomDatabase {
    public abstract UserDao userDao();

}
