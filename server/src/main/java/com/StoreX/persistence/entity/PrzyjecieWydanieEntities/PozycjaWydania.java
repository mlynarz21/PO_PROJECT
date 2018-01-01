package com.StoreX.persistence.entity.PrzyjecieWydanieEntities;

import com.StoreX.persistence.entity.TowarEntities.Towar;

import javax.persistence.*;

@Entity
public class PozycjaWydania {

    @Id
    @GeneratedValue
    private Long ID;
    private double ilosc;

    @ManyToOne
    private Towar towar;
    @ManyToOne
    private WydanieZamowienia wydanieZamowienia;

    public PozycjaWydania(){}

    public PozycjaWydania(Long ID, double ilosc, Towar towar, WydanieZamowienia wydanieZamowienia){
        this.ID=ID;
        this.ilosc=ilosc;
        this.towar=towar;
        this.wydanieZamowienia=wydanieZamowienia;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
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
