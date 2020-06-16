package com.todo.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Account implements Serializable {
    private String login;
    private String password;
    private Map<Integer, String> tasks;

    public Account(String login, String password) {
        this.login = login;
        this.password =password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public Map<Integer, String> getTasks() {
        if (this.tasks == null){
            this.tasks = new HashMap<>();
        }
        return this.tasks;
    }

    @Override
    public String toString() {
        return "Account{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", tasks=" + tasks +
                '}';
    }
}