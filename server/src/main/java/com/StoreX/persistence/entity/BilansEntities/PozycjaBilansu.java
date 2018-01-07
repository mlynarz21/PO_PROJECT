package com.StoreX.persistence.entity.BilansEntities;

import com.StoreX.persistence.entity.TowarEntities.Towar;

import javax.persistence.*;

@Entity
public class PozycjaBilansu {

    @Id
    @GeneratedValue
    private Long ID;

    private double ilosc;

    @ManyToOne
    private Bilans bilans;

    @ManyToOne
    private Towar towar;

    public PozycjaBilansu(){

    }

    public PozycjaBilansu(Long ID, double iosc, Towar towar, Bilans bilans){
        this.ID=ID;
        this.ilosc=iosc;
        this.bilans= bilans;
        this.towar=towar;
    }

    public PozycjaBilansu(double iosc, Towar towar, Bilans bilans){

        this.ilosc=iosc;
        this.bilans= bilans;
        this.towar=towar;
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

    public Bilans getBilans() {
        return bilans;
    }

    public void setBilans(Bilans bilans) {
        this.bilans = bilans;
    }
}