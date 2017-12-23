package com.StoreX.common.datatypes.bo;

import com.StoreX.persistence.entity.Lokalizacja;
import com.StoreX.persistence.entity.Towar;

public class UmieszczenieBO {
    private int ID;
    private double iloscWLokalizacji;
    private TowarBO towar;
    private LokalizacjaBO lokalizacja;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public double getIloscWLokalizacji() {
        return iloscWLokalizacji;
    }

    public void setIloscWLokalizacji(double iloscWLokalizacji) {
        this.iloscWLokalizacji = iloscWLokalizacji;
    }

    public TowarBO getTowar() {
        return towar;
    }

    public void setTowar(TowarBO towar) {
        this.towar = towar;
    }

    public LokalizacjaBO getLokalizacja() {
        return lokalizacja;
    }

    public void setLokalizacja(LokalizacjaBO lokalizacja) {
        this.lokalizacja = lokalizacja;
    }
}
