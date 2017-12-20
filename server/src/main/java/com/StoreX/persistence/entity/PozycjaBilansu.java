package com.StoreX.persistence.entity;

public class PozycjaBilansu {
    private int ID;
    private double ilosc;
    private Towar towar;
    private Bilans bilans;

    public PozycjaBilansu(int ID, double iosc, Towar towar, Bilans bilans){
        this.ID=ID;
        this.ilosc=iosc;
        this.towar=towar;
        this.bilans= bilans;
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