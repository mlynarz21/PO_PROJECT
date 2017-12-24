package com.StoreX.persistence.entity;

public class Klient {
    private int ID;
    private String login;
    private String imie;
    private String nazwisko;
    private String kodPocztowy;
    private String ulica;
    private String miasto;
    private String numerDomu;

    public Klient(int ID, String login, String imie, String nazwisko, String kodPocztowy, String ulica, String miasto, String numerDomu){
        this.ID=ID;
        this.login=login;
        this.imie=imie;
        this.nazwisko=nazwisko;
        this.kodPocztowy=kodPocztowy;
        this.ulica=ulica;
        this.miasto=miasto;
        this.numerDomu=numerDomu;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getKodPocztowy() {
        return kodPocztowy;
    }

    public void setKodPocztowy(String kodPocztowy) {
        this.kodPocztowy = kodPocztowy;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public String getNumerDomu() {
        return numerDomu;
    }

    public void setNumerDomu(String numerDomu) {
        this.numerDomu = numerDomu;
    }
}