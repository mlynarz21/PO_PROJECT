package com.StoreX.persistence.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Umieszczenie {

    @Id
    @GeneratedValue
    private int ID;
    private double iloscWLokalizacji;

   @ManyToOne
    private Towar towar;

    public Umieszczenie(int ID, double iloscWLokalizacji, Towar towar, Lokalizacja lokalizacja){
        this.ID=ID;
        this.iloscWLokalizacji=iloscWLokalizacji;
        this.towar=towar;
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


}
