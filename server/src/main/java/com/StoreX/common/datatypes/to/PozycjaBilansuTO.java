package com.StoreX.common.datatypes.to;

import com.StoreX.persistence.entity.Bilans;
import com.StoreX.persistence.entity.Towar;

public class PozycjaBilansuTO {
    private int ID;
    private double ilosc;
    private TowarTO towar;
    private BilansTO bilans;

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

    public BilansTO getBilans() {
        return bilans;
    }

    public void setBilans(BilansTO bilans) {
        this.bilans = bilans;
    }
}