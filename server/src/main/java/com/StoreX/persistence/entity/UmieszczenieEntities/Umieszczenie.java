package com.StoreX.persistence.entity.UmieszczenieEntities;

import com.StoreX.persistence.entity.TowarEntities.Towar;

import javax.persistence.*;

@Entity
public class Umieszczenie {

    @Id
    @GeneratedValue
    private Long ID;
    private double iloscWLokalizacji;

   @ManyToOne
    private Towar towar;

   @OneToOne
   private Lokalizacja lokalizacja;

   public Umieszczenie(){}
    public Umieszczenie(Long ID, double iloscWLokalizacji, Towar towar, Lokalizacja lokalizacja1){
        this.ID=ID;
        this.iloscWLokalizacji=iloscWLokalizacji;
        this.towar=towar;
        this.lokalizacja = lokalizacja1;
    }

    public Umieszczenie( double iloscWLokalizacji, Towar towar, Lokalizacja lokalizacja1){

        this.iloscWLokalizacji=iloscWLokalizacji;
        this.towar=towar;
        this.lokalizacja = lokalizacja1;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
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
