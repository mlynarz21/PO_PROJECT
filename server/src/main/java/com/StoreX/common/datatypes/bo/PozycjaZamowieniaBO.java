package com.StoreX.common.datatypes.bo;

import com.StoreX.persistence.entity.Towar;
import com.StoreX.persistence.entity.Zamowienie;

public class PozycjaZamowieniaBO {
    private int ID;
    private double ilosc;
    private double zrealizowano;
    private TowarBO towar;
    private ZamowienieBO zamowienie;

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

    public ZamowienieBO getZamowienie() {
        return zamowienie;
    }

    public void setZamowienie(ZamowienieBO zamowienie) {
        this.zamowienie = zamowienie;
    }

    public double getZrealizowano() {
        return zrealizowano;
    }

    public void setZrealizowano(double zrealizowano) {
        this.zrealizowano = zrealizowano;
    }
}
