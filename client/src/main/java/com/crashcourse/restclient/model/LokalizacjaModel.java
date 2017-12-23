package com.crashcourse.restclient.model;

import com.crashcourse.restclient.datatype.UmieszczenieTO;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.StringProperty;

public class LokalizacjaModel {
    private int ID;
    private StringProperty kod;
    private IntegerProperty numerRzedu;
    private IntegerProperty numerRegalu;
    private IntegerProperty numerSektora;
    private BooleanProperty zajete;
    private SimpleObjectProperty<UmieszczenieModel> umieszczenie;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public StringProperty getKod() {
        return kod;
    }

    public void setKod(StringProperty kod) {
        this.kod = kod;
    }

    public IntegerProperty getNumerRzedu() {
        return numerRzedu;
    }

    public void setNumerRzedu(IntegerProperty numerRzedu) {
        this.numerRzedu = numerRzedu;
    }

    public IntegerProperty getNumerRegalu() {
        return numerRegalu;
    }

    public void setNumerRegalu(IntegerProperty numerRegalu) {
        this.numerRegalu = numerRegalu;
    }

    public IntegerProperty getNumerSektora() {
        return numerSektora;
    }

    public void setNumerSektora(IntegerProperty numerSektora) {
        this.numerSektora = numerSektora;
    }

    public BooleanProperty isZajete() {
        return zajete;
    }

    public void setZajete(BooleanProperty zajete) {
        this.zajete = zajete;
    }

    public SimpleObjectProperty<UmieszczenieModel> getUmieszczenie() {
        return umieszczenie;
    }

    public void setUmieszczenie(SimpleObjectProperty<UmieszczenieModel> umieszczenie) {
        this.umieszczenie = umieszczenie;
    }
}

