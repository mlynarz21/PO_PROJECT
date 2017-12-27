package com.StoreX.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Kategoria {

    @Id
    @GeneratedValue
    private Long ID;
    private String kategoria;


    public  Kategoria(){}
    public Kategoria(Long ID, String kategoria){
        this.ID=ID;
        this.kategoria=kategoria;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getKategoria() {
        return kategoria;
    }

    public void setKategoria(String kategoria) {
        this.kategoria = kategoria;
    }
}
