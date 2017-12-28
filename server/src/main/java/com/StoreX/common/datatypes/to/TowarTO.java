package com.StoreX.common.datatypes.to;

import com.StoreX.persistence.entity.Jednostka;
import com.StoreX.persistence.entity.Kategoria;
import com.StoreX.persistence.entity.Umieszczenie;

import java.util.List;

public class TowarTO {
    private Long ID;
    private String nazwa;
    private String kod;
    private double ilostan=0;
    private int czasZalegania;
    private double iloscZablokowana=0;
    private boolean zalega=false;
    private boolean potrzebujeZamowienia=false;
    private double iloscMinimalna;
    private JednostkaTO jednostka;
    private KategoriaTO kategoria;
    private List<UmieszczenieTO> umieszczenia;

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

    public JednostkaTO getJednostka() {
        return jednostka;
    }

    public void setJednostka(JednostkaTO jednostka) {
        this.jednostka = jednostka;
    }

    public KategoriaTO getKategoria() {
        return kategoria;
    }

    public void setKategoria(KategoriaTO kategoria) {
        this.kategoria = kategoria;
    }

    public List<UmieszczenieTO> getUmieszczenia() {
        return umieszczenia;
    }

    public void setUmieszczenia(List<UmieszczenieTO> umieszczenia) {
        this.umieszczenia = umieszczenia;
    }
}
