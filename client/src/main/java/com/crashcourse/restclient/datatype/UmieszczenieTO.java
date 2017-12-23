package com.crashcourse.restclient.datatype;

public class UmieszczenieTO {
    private int ID;
    private double iloscWLokalizacji;
    private TowarTO towar;
    private LokalizacjaTO lokalizacja;

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
