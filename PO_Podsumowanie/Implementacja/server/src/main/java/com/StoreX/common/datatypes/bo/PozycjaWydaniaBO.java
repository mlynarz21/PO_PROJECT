package com.StoreX.common.datatypes.bo;

/**
 * Obiekt biznesowy klasy PozycjaWydania - używany do operacji w warstwie logiki biznesowej
 */
public class PozycjaWydaniaBO {
    private Long ID;
    private double ilosc;
    private TowarBO towar;
    private WydanieZamowieniaBO wydanieZamowienia;

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

    public TowarBO getTowar() {
        return towar;
    }

    public void setTowar(TowarBO towar) {
        this.towar = towar;
    }

    public WydanieZamowieniaBO getWydanieZamowienia() {
        return wydanieZamowienia;
    }

    public void setWydanieZamowienia(WydanieZamowieniaBO wydanieZamowienia) {
        this.wydanieZamowienia = wydanieZamowienia;
    }
}
