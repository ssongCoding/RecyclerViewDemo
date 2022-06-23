package com.example.recyclerviewdemo;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Item 각 요소에 담을 객체
 */
@Entity
public class User {
    @PrimaryKey(autoGenerate = true)
    private int key = 0; // Primary Key

    private String profile;
    private String id;
    private String userName;

    /*** 생성자 ***/
    public User(String id, String userName){
        this.id = id;
        this.userName = userName;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    // Alt + Insert
    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
