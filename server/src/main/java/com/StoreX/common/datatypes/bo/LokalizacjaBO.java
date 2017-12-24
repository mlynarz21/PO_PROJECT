package com.StoreX.common.datatypes.bo;

import com.StoreX.persistence.entity.Umieszczenie;

public class LokalizacjaBO {
    private int ID;
    private String kod;
    private int numerRzedu;
    private int numerRegalu;
    private int numerSektora;
    private boolean zajete;
    private UmieszczenieBO umieszczenie;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getKod() {
        return kod;
    }

    public void setKod(String kod) {
        this.kod = kod;
    }

    public int getNumerRzedu() {
        return numerRzedu;
    }

    public void setNumerRzedu(int numerRzedu) {
        this.numerRzedu = numerRzedu;
    }

    public int getNumerRegalu() {
        return numerRegalu;
    }

    public void setNumerRegalu(int numerRegalu) {
        this.numerRegalu = numerRegalu;
    }

    public int getNumerSektora() {
        return numerSektora;
    }

    public void setNumerSektora(int numerSektora) {
        this.numerSektora = numerSektora;
    }

    public boolean isZajete() {
        return zajete;
    }

    public void setZajete(boolean zajete) {
        this.zajete = zajete;
    }

    public UmieszczenieBO getUmieszczenie() {
        return umieszczenie;
    }

    public void setUmieszczenie(UmieszczenieBO umieszczenie) {
        this.umieszczenie = umieszczenie;
    }
}
