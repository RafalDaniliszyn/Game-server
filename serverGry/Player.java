package com.example.serverGry;

import org.springframework.stereotype.Component;

@Component
public class Player {


    int id;
    int polozenieNaTablicyX;
    int polozenieNaTablicyY;

    boolean status;
    int poziomMapy;
    String name;
    String wiadomosc;

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

    public void setPolozenieNaTablicyX(int polozenieNaTablicyX) {
        this.polozenieNaTablicyX = polozenieNaTablicyX;
    }

    public void setPolozenieNaTablicyY(int polozenieNaTablicyY) {
        this.polozenieNaTablicyY = polozenieNaTablicyY;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getId() {
        return id;
    }

    public int getPolozenieNaTablicyX() {
        return polozenieNaTablicyX;
    }

    public int getPolozenieNaTablicyY() {
        return polozenieNaTablicyY;
    }

    public String getName() {
        return name;
    }


}
