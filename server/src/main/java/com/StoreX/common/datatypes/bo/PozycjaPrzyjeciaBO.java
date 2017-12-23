package com.StoreX.common.datatypes.bo;

import com.StoreX.persistence.entity.PrzyjecieZamowienia;
import com.StoreX.persistence.entity.Towar;

public class PozycjaPrzyjeciaBO {
    private int ID;
    private double ilosc;
    private TowarBO towar;
    private PrzyjecieZamowieniaBO przyjecieZamowienia;


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

    public PrzyjecieZamowieniaBO getPrzyjecieZamowienia() {
        return przyjecieZamowienia;
    }

    public void setPrzyjecieZamowienia(PrzyjecieZamowieniaBO przyjecieZamowienia) {
        this.przyjecieZamowienia = przyjecieZamowienia;
    }
}
