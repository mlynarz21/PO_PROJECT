package com.StoreX.common.datatypes.to;

/**
 * klasa PozycjaWydania obiektu transferowego - używana w komunikacji między serwerem a klientem
 */
public class PozycjaWydaniaTO {
    private Long ID;
    private double ilosc;
    private TowarTO towar;
    private WydanieZamowieniaTO wydanieZamowienia;

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

    public TowarTO getTowar() {
        return towar;
    }

    public void setTowar(TowarTO towar) {
        this.towar = towar;
    }

    public WydanieZamowieniaTO getWydanieZamowienia() {
        return wydanieZamowienia;
    }

    public void setWydanieZamowienia(WydanieZamowieniaTO wydanieZamowienia) {
        this.wydanieZamowienia = wydanieZamowienia;
    }
}
