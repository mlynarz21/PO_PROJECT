package com.StoreX.persistence.entity;

public class PozycjaPrzyjecia {
    private int ID;
    private double ilosc;
    private Towar towar;
    private PrzyjecieZamowienia przyjecieZamowienia;

    public PozycjaPrzyjecia(int ID, double ilosc, Towar towar, PrzyjecieZamowienia przyjecieZamowienia){
        this.ID=ID;
        this.ilosc=ilosc;
        this.towar=towar;
        this.przyjecieZamowienia=przyjecieZamowienia;
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

    public PrzyjecieZamowienia getPrzyjecieZamowienia() {
        return przyjecieZamowienia;
    }

    public void setPrzyjecieZamowienia(PrzyjecieZamowienia przyjecieZamowienia) {
        this.przyjecieZamowienia = przyjecieZamowienia;
    }
}
