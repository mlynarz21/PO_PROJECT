package com.crashcourse.restclient.model;

import com.crashcourse.restclient.datatype.UmieszczenieTO;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;

public class UmieszczenieModel {
    private int ID;
    private DoubleProperty iloscWLokalizacji;
    private SimpleObjectProperty<TowarModel> towar;
    private SimpleObjectProperty<LokalizacjaModel> lokalizacja;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public DoubleProperty getIloscWLokalizacji() {
        return iloscWLokalizacji;
    }

    public void setIloscWLokalizacji(DoubleProperty iloscWLokalizacji) {
        this.iloscWLokalizacji = iloscWLokalizacji;
    }

    public SimpleObjectProperty<TowarModel> getTowar() {
        return towar;
    }

    public void setTowar(SimpleObjectProperty<TowarModel> towar) {
        this.towar = towar;
    }

    public SimpleObjectProperty<LokalizacjaModel> getLokalizacja() {
        return lokalizacja;
    }

    public void setLokalizacja(SimpleObjectProperty<LokalizacjaModel> lokalizacja) {
        this.lokalizacja = lokalizacja;
    }

    public static UmieszczenieModel fromUmieszenieTo(UmieszczenieTO umieszczenieTO) {
        UmieszczenieModel umieszczenieModel = new UmieszczenieModel();
        umieszczenieModel.ID = umieszczenieTO.getID();
        umieszczenieModel.iloscWLokalizacji = new SimpleDoubleProperty(umieszczenieTO.getIloscWLokalizacji());
        umieszczenieModel.lokalizacja = new SimpleObjectProperty<>(LokalizacjaModel.fromLokalizacjaTo(umieszczenieTO.getLokalizacja()));
        umieszczenieModel.towar = new SimpleObjectProperty<>(TowarModel.fromTowarTo(umieszczenieTO.getTowar()));
        return umieszczenieModel;
    }
}
