package com.example.serverGry;

import org.springframework.stereotype.Component;

@Component
public class OnlinePlayer {
    int id;
    int x;
    int y;

    boolean status;
    int poziomMapy;
    int liczbaGraczy;
    String name;
    String wiadomosc;


    public int getLiczbaGraczy() {
        return liczbaGraczy;
    }

    public void setLiczbaGraczy(int liczbaGraczy) {
        this.liczbaGraczy = liczbaGraczy;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean getStatus() {
        return status;
    }

    public int getPoziomMapy() {
        return poziomMapy;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setPoziomMapy(int poziomMapy) {
        this.poziomMapy = poziomMapy;
    }


    public void setWiadomosc(String wiadomosc) {
        this.wiadomosc = wiadomosc;
    }

    public String getWiadomosc() {
        return wiadomosc;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
