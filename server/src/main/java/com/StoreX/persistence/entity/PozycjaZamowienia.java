package com.StoreX.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class PozycjaZamowienia {

    @Id
    @GeneratedValue
    private int ID;
    private double ilosc;
    private double zrealizowano;

    @ManyToOne
    private Towar towar;
    @ManyToOne
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
