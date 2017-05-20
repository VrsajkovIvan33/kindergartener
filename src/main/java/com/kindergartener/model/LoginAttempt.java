package com.kindergartener.model;

import java.io.Serializable;

/**
 * Created by Hp on 4/30/2017.
 */

public class LoginAttempt implements Serializable {

    private String username;
    private String password;

    public LoginAttempt() {}

    public LoginAttempt(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
