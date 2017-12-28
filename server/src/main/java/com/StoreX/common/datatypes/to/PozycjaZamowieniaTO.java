package com.StoreX.common.datatypes.to;

import com.StoreX.persistence.entity.Towar;
import com.StoreX.persistence.entity.Zamowienie;
import com.StoreX.persistence.entity.ZamowienieZakupu;

public class PozycjaZamowieniaTO {
    private Long ID;
    private double ilosc;
    private double zrealizowano;
    private TowarTO towar;
    private ZamowienieZakupuTO zamowienie;

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

    public ZamowienieTO getZamowienie() {
        return zamowienie;
    }

    public void setZamowienie(ZamowienieZakupuTO zamowienie) {
        this.zamowienie = zamowienie;
    }

    public double getZrealizowano() {
        return zrealizowano;
    }

    public void setZrealizowano(double zrealizowano) {
        this.zrealizowano = zrealizowano;
    }
}
