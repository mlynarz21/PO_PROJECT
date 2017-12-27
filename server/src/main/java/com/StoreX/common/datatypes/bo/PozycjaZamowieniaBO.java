package com.StoreX.common.datatypes.bo;

import com.StoreX.persistence.entity.Towar;
import com.StoreX.persistence.entity.Zamowienie;
import com.StoreX.persistence.entity.ZamowienieZakupu;

public class PozycjaZamowieniaBO {
    private Long ID;
    private double ilosc;
    private double zrealizowano;
    private TowarBO towar;
    private ZamowienieZakupuBO zamowienie;

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

    public ZamowienieBO getZamowienie() {
        return zamowienie;
    }

    public void setZamowienie(ZamowienieZakupuBO zamowienie) {
        this.zamowienie = zamowienie;
    }

    public double getZrealizowano() {
        return zrealizowano;
    }

    public void setZrealizowano(double zrealizowano) {
        this.zrealizowano = zrealizowano;
    }
}
