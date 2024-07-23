package com.example.java_9;

import java.util.ArrayList;

public class UserStorage {

    private ArrayList<User> users = new ArrayList<>();

    private static UserStorage us = null;

    private UserStorage() {
    }
    public static UserStorage getInstance() {
        if (us == null) {
            us = new UserStorage();
        }
        return us;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public ArrayList<User> getUsers() {
        return users;
    }
}
