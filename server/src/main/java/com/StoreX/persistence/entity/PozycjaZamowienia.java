package com.StoreX.persistence.entity;

public class PozycjaZamowienia {
    private int ID;
    private double ilosc;
    private double zrealizowano;
    private Towar towar;
    private Zamowienie zamowienie;

    public PozycjaZamowienia(int ID, double ilosc,double zrealizowano, Towar towar, Zamowienie zamowienie){
        this.ID=ID;
        this.ilosc=ilosc;
        this.towar=towar;
        this.zrealizowano=zrealizowano;
        this.zamowienie=zamowienie;
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

    public Zamowienie getZamowienie() {
        return zamowienie;
    }

    public void setZamowienie(Zamowienie zamowienie) {
        this.zamowienie = zamowienie;
    }

    public double getZrealizowano() {
        return zrealizowano;
    }

    public void setZrealizowano(double zrealizowano) {
        this.zrealizowano = zrealizowano;
    }
}
