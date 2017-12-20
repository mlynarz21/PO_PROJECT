package com.StoreX.persistence.entity;

public class Jednostka {
    private int ID;
    private String rodzaj;

    public Jednostka(int ID, String rodzaj){
        this.ID=ID;
        this.rodzaj=rodzaj;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getRodzaj() {
        return rodzaj;
    }

    public void setRodzaj(String rodzaj) {
        this.rodzaj = rodzaj;
    }
}
