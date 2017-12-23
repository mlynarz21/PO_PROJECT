package com.StoreX.common.datatypes.to;

import com.StoreX.persistence.entity.PrzyjecieZamowienia;
import com.StoreX.persistence.entity.Towar;

public class PozycjaPrzyjeciaTO {
    private int ID;
    private double ilosc;
    private TowarTO towar;
    private PrzyjecieZamowieniaTO przyjecieZamowienia;

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

    public PrzyjecieZamowieniaTO getPrzyjecieZamowienia() {
        return przyjecieZamowienia;
    }

    public void setPrzyjecieZamowienia(PrzyjecieZamowieniaTO przyjecieZamowienia) {
        this.przyjecieZamowienia = przyjecieZamowienia;
    }
}
