package com.StoreX.common.datatypes.bo;

import com.StoreX.persistence.entity.Towar;
import com.StoreX.persistence.entity.WydanieZamowienia;

public class PozycjaWydaniaBO {
    private int ID;
    private double ilosc;
    private TowarBO towar;
    private WydanieZamowieniaBO wydanieZamowienia;

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
