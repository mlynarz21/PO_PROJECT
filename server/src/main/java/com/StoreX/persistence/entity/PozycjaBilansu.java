package com.StoreX.persistence.entity;

import javax.persistence.*;

@Entity
public class PozycjaBilansu {

    @Id
    @GeneratedValue
    private int ID;

    private double ilosc;

    @ManyToOne
    private Bilans bilans;

    @ManyToOne
    private Towar towar;

    public PozycjaBilansu(){

    }

    public PozycjaBilansu(int ID, double iosc, Towar towar, Bilans bilans){
        this.ID=ID;
        this.ilosc=iosc;
        this.bilans= bilans;
        this.towar=towar;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public double getIlosc() {
        return ilosc;
    }

    public void setIlosc(double ilosc) {
        this.ilosc = ilosc;
    }

    public Towar getTowar() {
               return towar;
           }

    public void setTowar(Towar towar) {
                this.towar = towar;
           }

    public Bilans getBilans() {
        return bilans;
    }

    public void setBilans(Bilans bilans) {
        this.bilans = bilans;
    }
}