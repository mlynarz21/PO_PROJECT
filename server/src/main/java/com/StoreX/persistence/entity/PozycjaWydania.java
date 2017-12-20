package com.StoreX.persistence.entity;

public class PozycjaWydania {
    private int ID;
    private double ilosc;
    private Towar towar;
    private WydanieZamowienia wydanieZamowienia;

    public PozycjaWydania(int ID, double ilosc, Towar towar, WydanieZamowienia wydanieZamowienia){
        this.ID=ID;
        this.ilosc=ilosc;
        this.towar=towar;
        this.wydanieZamowienia=wydanieZamowienia;
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

    public WydanieZamowienia getWydanieZamowienia() {
        return wydanieZamowienia;
    }

    public void setWydanieZamowienia(WydanieZamowienia wydanieZamowienia) {
        this.wydanieZamowienia = wydanieZamowienia;
    }
}
