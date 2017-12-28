package com.crashcourse.restclient.datatype;

public class UmieszczenieTO {
    private Long ID;
    private double iloscWLokalizacji;
    private TowarTO towar;
    private LokalizacjaTO lokalizacja;

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

    public TowarTO getTowar() {
        return towar;
    }

    public void setTowar(TowarTO towar) {
        this.towar = towar;
    }

    public LokalizacjaTO getLokalizacja() {
        return lokalizacja;
    }

    public void setLokalizacja(LokalizacjaTO lokalizacja) {
        this.lokalizacja = lokalizacja;
    }
}
