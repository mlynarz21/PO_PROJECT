package com.StoreX.persistence.entity;

public class Lokalizacja {
    private int ID;
    private String kod;
    private int numerRzedu;
    private int numerRegalu;
    private int numerSektora;
    private boolean zajete;
    private Umieszczenie umieszczenie;

    public Lokalizacja(int ID, String kod,int numerRegalu, int numerRzedu, int numerSektora, boolean zajete, Umieszczenie umieszczenie){
        this.ID=ID;
        this.kod=kod;
        this.numerRzedu=numerRzedu;
        this.numerRegalu=numerRegalu;
        this.numerSektora=numerSektora;
        this.zajete=zajete;
        this.umieszczenie=umieszczenie;
    }

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

    public Umieszczenie getUmieszczenie() {
        return umieszczenie;
    }

    public void setUmieszczenie(Umieszczenie umieszczenie) {
        this.umieszczenie = umieszczenie;
    }
}

