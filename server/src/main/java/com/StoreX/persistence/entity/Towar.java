package com.StoreX.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Towar {

    @Id
    @GeneratedValue
    private Long ID;
    private String nazwa;
    private String kod;
    private double ilostan=0;
    private int czasZalegania;
    private double iloscZablokowana=0;
    private boolean zalega=false;
    private boolean potrzebujeZamowienia=false;
    private double iloscMinimalna;
    @ManyToOne
    private Jednostka jednostka;
    @ManyToOne
    private Kategoria kategoria;


    public Towar(Long ID,String kod,String nazwa, int czasZalegania, double iloscMinimalna,Jednostka jednostka,Kategoria kategoria){
        this.ID=ID;
        this.kod=kod;
        this.nazwa=nazwa;
        this.czasZalegania=czasZalegania;
        this.iloscMinimalna=iloscMinimalna;
        this.jednostka=jednostka;
        this.kategoria=kategoria;
    }

    public Towar() {

    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getKod() {
        return kod;
    }

    public void setKod(String kod) {
        this.kod = kod;
    }

    public double getIlostan() {
        return ilostan;
    }

    public void setIlostan(double ilostan) {
        this.ilostan = ilostan;
    }

    public int getCzasZalegania() {
        return czasZalegania;
    }

    public void setCzasZalegania(int czasZalegania) {
        this.czasZalegania = czasZalegania;
    }

    public double getIloscZablokowana() {
        return iloscZablokowana;
    }

    public void setIloscZablokowana(double iloscZablokowana) {
        this.iloscZablokowana = iloscZablokowana;
    }

    public boolean isZalega() {
        return zalega;
    }

    public void setZalega(boolean zalega) {
        this.zalega = zalega;
    }

    public boolean isPotrzebujeZamowienia() {
        return potrzebujeZamowienia;
    }

    public void setPotrzebujeZamowienia(boolean potrzebujeZamowienia) {
        this.potrzebujeZamowienia = potrzebujeZamowienia;
    }

    public double getIloscMinimalna() {
        return iloscMinimalna;
    }

    public void setIloscMinimalna(double iloscMinimalna) {
        this.iloscMinimalna = iloscMinimalna;
    }

    public Jednostka getJednostka() {
        return jednostka;
    }

    public void setJednostka(Jednostka jednostka) {
        this.jednostka = jednostka;
    }

    public Kategoria getKategoria() {
        return kategoria;
    }

    public void setKategoria(Kategoria kategoria) {
        this.kategoria = kategoria;
    }
}
