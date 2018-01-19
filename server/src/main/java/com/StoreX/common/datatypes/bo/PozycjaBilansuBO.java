package com.StoreX.common.datatypes.bo;

/**
 * Obiekt biznesowy klasy Bilans - używany do operacji w warstwie logiki biznesowej
 */
public class PozycjaBilansuBO {
    private Long ID;
    private double ilosc;
    private TowarBO towar;
    private BilansBO bilans;

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

    public BilansBO getBilans() {
        return bilans;
    }

    public void setBilans(BilansBO bilans) {
        this.bilans = bilans;
    }
}