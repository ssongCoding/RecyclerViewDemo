package com.example.recyclerviewdemo;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

/**
 * Data Access Object
 */
@Dao
public interface UserDao {

    @Insert // 삽입
    void setInsertUser(User user);

    @Update // 수정
    void setUpdateUser(User user);

    @Delete // 삭제
    void setDeleteUser(User user);

    @Query("SELECT * FROM User")
    List<User> getUserAll();
}
