package com.example.recyclerviewdemo;

/**
 * Item 각 요소에 담을 객체
 */
public class User {
    private String profile;
    private String id;
    private String userName;

    /*** 생성자 ***/
    public User(String id, String userName){
        this.id = id;
        this.userName = userName;
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
