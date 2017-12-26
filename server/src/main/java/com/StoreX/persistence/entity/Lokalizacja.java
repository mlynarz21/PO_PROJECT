package com.StoreX.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Lokalizacja {

    @Id
    @GeneratedValue
    private Long ID;
    private String kod;
    private int numerRzedu;
    private int numerRegalu;
    private int numerSektora;
    private boolean zajete;


    public Lokalizacja(Long ID, String kod,int numerRegalu, int numerRzedu, int numerSektora, boolean zajete){
        this.ID=ID;
        this.kod=kod;
        this.numerRzedu=numerRzedu;
        this.numerRegalu=numerRegalu;
        this.numerSektora=numerSektora;
        this.zajete=zajete;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getKod() {
        return kod;
    }

    public void setKod(String kod) {
        this.kod = kod;
    }

    public int getNumerRzedu() {
        return numerRzedu;
    }

    public void setNumerRzedu(int numerRzedu) {
        this.numerRzedu = numerRzedu;
    }

    public int getNumerRegalu() {
        return numerRegalu;
    }

    public void setNumerRegalu(int numerRegalu) {
        this.numerRegalu = numerRegalu;
    }

    public int getNumerSektora() {
        return numerSektora;
    }

    public void setNumerSektora(int numerSektora) {
        this.numerSektora = numerSektora;
    }

    public boolean isZajete() {
        return zajete;
    }

    public void setZajete(boolean zajete) {
        this.zajete = zajete;
    }


}

