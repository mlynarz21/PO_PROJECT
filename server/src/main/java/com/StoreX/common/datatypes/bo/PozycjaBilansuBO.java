package com.StoreX.common.datatypes.bo;

import com.StoreX.persistence.entity.Bilans;
import com.StoreX.persistence.entity.Towar;

public class PozycjaBilansuBO {
    private int ID;
    private double ilosc;
    private TowarBO towar;
    private BilansBO bilans;

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

    public BilansBO getBilans() {
        return bilans;
    }

    public void setBilans(BilansBO bilans) {
        this.bilans = bilans;
    }
}