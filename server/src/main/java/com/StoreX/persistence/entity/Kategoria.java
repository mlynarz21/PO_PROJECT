package com.StoreX.persistence.entity;

public class Kategoria {
    private int ID;
    private String kategoria;

    public Kategoria(int ID, String kategoria){
        this.ID=ID;
        this.kategoria=kategoria;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getKategoria() {
        return kategoria;
    }

    public void setKategoria(String kategoria) {
        this.kategoria = kategoria;
    }
}
