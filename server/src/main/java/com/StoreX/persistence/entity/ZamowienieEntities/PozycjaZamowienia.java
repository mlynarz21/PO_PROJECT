package com.StoreX.persistence.entity.ZamowienieEntities;

import com.StoreX.persistence.entity.TowarEntities.Towar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * PozycjaZamowienia Entity - klasa reprezentacji obiektów bazy
 */
@Entity
public class PozycjaZamowienia {

    @Id
    @GeneratedValue
    private Long ID;
    private double ilosc;
    private double zrealizowano;

    @ManyToOne
    private Towar towar;
    @ManyToOne
    private ZamowienieZakupu zamowienie;

    public PozycjaZamowienia(){}

    public PozycjaZamowienia(Long ID, double ilosc,double zrealizowano, Towar towar, ZamowienieZakupu zamowienie){
        this.ID=ID;
        this.ilosc=ilosc;
        this.towar=towar;
        this.zrealizowano=zrealizowano;
        this.zamowienie=zamowienie;
    }

    public PozycjaZamowienia( double ilosc,double zrealizowano, Towar towar, ZamowienieZakupu zamowienie){

        this.ilosc=ilosc;
        this.towar=towar;
        this.zrealizowano=zrealizowano;
        this.zamowienie=zamowienie;
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

    public ZamowienieZakupu getZamowienie() {
        return zamowienie;
    }

    public void setZamowienie(ZamowienieZakupu zamowienie) {
        this.zamowienie = zamowienie;
    }

    public double getZrealizowano() {
        return zrealizowano;
    }

    public void setZrealizowano(double zrealizowano) {
        this.zrealizowano = zrealizowano;
    }
}
