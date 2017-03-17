package com.sen5.test.mvp.bean;

/**
 * Created by chenqianghua on 2017/2/9.
 */

public class User {
    private String userName;
    private String password;

    private String getUserName() {
        return userName;
    }

    private void setUserName(String userName) {
        this.userName = userName;
    }

    private String getPassword() {
        return password;
    }

    private void setPassword(String password) {
        this.password = password;
    }
}
