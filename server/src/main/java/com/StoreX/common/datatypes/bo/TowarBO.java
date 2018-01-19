package com.StoreX.common.datatypes.bo;

/**
 * Obiekt biznesowy klasy Towar - używany do operacji w warstwie logiki biznesowej
 */
public class TowarBO {
    private Long ID;
    private String nazwa;
    private String kod;
    private double ilostan=0;
    private int czasZalegania;
    private double iloscZablokowana=0;
    private boolean zalega=false;
    private boolean potrzebujeZamowienia=false;
    private double iloscMinimalna;
    private JednostkaBO jednostka;
    private KategoriaBO kategoria;

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

    public JednostkaBO getJednostka() {
        return jednostka;
    }

    public void setJednostka(JednostkaBO jednostka) {
        this.jednostka = jednostka;
    }

    public KategoriaBO getKategoria() {
        return kategoria;
    }

    public void setKategoria(KategoriaBO kategoria) {
        this.kategoria = kategoria;
    }
}
