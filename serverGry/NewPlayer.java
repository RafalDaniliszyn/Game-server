package com.example.serverGry;

import org.springframework.stereotype.Component;

@Component
public class NewPlayer {
    String name;
    int id;
    String password;

    public NewPlayer() {

    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
