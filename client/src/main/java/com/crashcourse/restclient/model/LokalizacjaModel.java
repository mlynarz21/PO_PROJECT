package com.crashcourse.restclient.model;

import com.crashcourse.restclient.datatype.KategoriaTO;
import com.crashcourse.restclient.datatype.LokalizacjaTO;
import com.crashcourse.restclient.datatype.UmieszczenieTO;
import javafx.beans.property.*;

import java.util.List;

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

    public static LokalizacjaModel fromLokalizacjaTo(LokalizacjaTO lokalizacjaTO) {
        LokalizacjaModel lokalizacjaModel = new LokalizacjaModel();
        lokalizacjaModel.ID = lokalizacjaTO.getID();
        lokalizacjaModel.kod = new SimpleStringProperty(lokalizacjaTO.getKod());
        lokalizacjaModel.numerRegalu = new SimpleIntegerProperty(lokalizacjaTO.getNumerRegalu());
        lokalizacjaModel.numerRzedu = new SimpleIntegerProperty(lokalizacjaTO.getNumerRzedu());
        lokalizacjaModel.numerSektora = new SimpleIntegerProperty(lokalizacjaTO.getNumerSektora());
        lokalizacjaModel.zajete = new SimpleBooleanProperty(lokalizacjaTO.isZajete());
        lokalizacjaModel.umieszczenie = new SimpleObjectProperty<>(UmieszczenieModel.fromUmieszenieTo(lokalizacjaTO.getUmieszczenie()));
        return lokalizacjaModel;
    }
}

