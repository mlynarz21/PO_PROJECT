package com.StoreX.persistence.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Jednostka {

    @Id
    @GeneratedValue
    private int ID;

    @Size(max = 32)
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
