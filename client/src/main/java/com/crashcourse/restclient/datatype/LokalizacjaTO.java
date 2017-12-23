package com.crashcourse.restclient.datatype;

public class LokalizacjaTO {
    private int ID;
    private String kod;
    private int numerRzedu;
    private int numerRegalu;
    private int numerSektora;
    private boolean zajete;
    private UmieszczenieTO umieszczenie;

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

    public UmieszczenieTO getUmieszczenie() {
        return umieszczenie;
    }

    public void setUmieszczenie(UmieszczenieTO umieszczenie) {
        this.umieszczenie = umieszczenie;
    }
}

