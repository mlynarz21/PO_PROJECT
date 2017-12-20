package com.StoreX.persistence.entity;

import java.util.ArrayList;
import java.util.List;

public class Umieszczenie {
    private int ID;
    private double iloscWLokalizacji;
    private Towar towar;
    private Lokalizacja lokalizacja;

    public Umieszczenie(int ID, double iloscWLokalizacji, Towar towar, Lokalizacja lokalizacja){
        this.ID=ID;
        this.iloscWLokalizacji=iloscWLokalizacji;
        this.towar=towar;
        this.lokalizacja=lokalizacja;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public double getIloscWLokalizacji() {
        return iloscWLokalizacji;
    }

    public void setIloscWLokalizacji(double iloscWLokalizacji) {
        this.iloscWLokalizacji = iloscWLokalizacji;
    }

    public Towar getTowar() {
        return towar;
    }

    public void setTowar(Towar towar) {
        this.towar = towar;
    }

    public Lokalizacja getLokalizacja() {
        return lokalizacja;
    }

    public void setLokalizacja(Lokalizacja lokalizacja) {
        this.lokalizacja = lokalizacja;
    }
}
