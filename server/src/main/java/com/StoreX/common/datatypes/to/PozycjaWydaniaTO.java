package com.StoreX.common.datatypes.to;

import com.StoreX.persistence.entity.Towar;
import com.StoreX.persistence.entity.WydanieZamowienia;

public class PozycjaWydaniaTO {
    private int ID;
    private double ilosc;
    private TowarTO towar;
    private WydanieZamowieniaTO wydanieZamowienia;

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
