package com.StoreX.common.datatypes.bo;

public class UmieszczenieBO {
    private Long ID;
    private double iloscWLokalizacji;
    private TowarBO towar;
    private LokalizacjaBO lokalizacja;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
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
