package com.crashcourse.restclient.model;

import com.crashcourse.restclient.datatype.KategoriaTO;
import com.crashcourse.restclient.datatype.KlientTO;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class KlientModel {
    private int ID;
    private StringProperty login;
    private StringProperty imie;
    private StringProperty nazwisko;
    private StringProperty kodPocztowy;
    private StringProperty ulica;
    private StringProperty miasto;
    private StringProperty numerDomu;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public StringProperty getLogin() {
        return login;
    }

    public void setLogin(StringProperty login) {
        this.login = login;
    }

    public StringProperty getImie() {
        return imie;
    }

    public void setImie(StringProperty imie) {
        this.imie = imie;
    }

    public StringProperty getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(StringProperty nazwisko) {
        this.nazwisko = nazwisko;
    }

    public StringProperty getKodPocztowy() {
        return kodPocztowy;
    }

    public void setKodPocztowy(StringProperty kodPocztowy) {
        this.kodPocztowy = kodPocztowy;
    }

    public StringProperty getUlica() {
        return ulica;
    }

    public void setUlica(StringProperty ulica) {
        this.ulica = ulica;
    }

    public StringProperty getMiasto() {
        return miasto;
    }

    public void setMiasto(StringProperty miasto) {
        this.miasto = miasto;
    }

    public StringProperty getNumerDomu() {
        return numerDomu;
    }

    public void setNumerDomu(StringProperty numerDomu) {
        this.numerDomu = numerDomu;
    }

    public static KlientModel fromKlientTo(KlientTO klientTO) {
        KlientModel klientModel = new KlientModel();
        klientModel.ID = klientTO.getID();
        klientModel.login = new SimpleStringProperty(klientTO.getLogin());
        klientModel.imie = new SimpleStringProperty(klientTO.getImie());
        klientModel.kodPocztowy = new SimpleStringProperty(klientTO.getKodPocztowy());
        klientModel.miasto = new SimpleStringProperty(klientTO.getMiasto());
        klientModel.nazwisko = new SimpleStringProperty(klientTO.getNazwisko());
        klientModel.numerDomu = new SimpleStringProperty(klientTO.getNumerDomu());
        klientModel.ulica = new SimpleStringProperty(klientTO.getUlica());
        return klientModel;
    }
}
