package com.ddoong2.security;

/**
 * User
 *
 * Created by kdj on 2018. 8. 6.
 */
class User {
    private String id;
    private String password;

    public User(String id, String password) {
        this.id = id;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public boolean matchPassword(String password) {
        return this.password.equals(password);
    }
}
