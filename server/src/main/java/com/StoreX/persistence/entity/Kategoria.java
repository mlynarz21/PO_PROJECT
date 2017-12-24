package com.StoreX.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Kategoria {

    @Id
    @GeneratedValue
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
