package com.StoreX.common.datatypes.to;

import com.StoreX.persistence.entity.Towar;
import com.StoreX.persistence.entity.Zamowienie;

public class PozycjaZamowieniaTO {
    private int ID;
    private double ilosc;
    private double zrealizowano;
    private TowarTO towar;
    private ZamowienieTO zamowienie;

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

    public ZamowienieTO getZamowienie() {
        return zamowienie;
    }

    public void setZamowienie(ZamowienieTO zamowienie) {
        this.zamowienie = zamowienie;
    }

    public double getZrealizowano() {
        return zrealizowano;
    }

    public void setZrealizowano(double zrealizowano) {
        this.zrealizowano = zrealizowano;
    }
}
