package com.StoreX.common.datatypes.to;

/**
 * klasa PozycjaBilansu obiektu transferowego - używana w komunikacji między serwerem a klientem
 */
public class PozycjaBilansuTO {
    private Long ID;
    private double ilosc;
    private TowarTO towar;
    private BilansTO bilans;

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

    public BilansTO getBilans() {
        return bilans;
    }

    public void setBilans(BilansTO bilans) {
        this.bilans = bilans;
    }
}