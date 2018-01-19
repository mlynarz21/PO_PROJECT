package com.crashcourse.restclient.model;

import com.crashcourse.restclient.datatype.UmieszczenieTO;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;

/**
 * klasa Umieszczenie modelowa - używana w warstwie prezentacji
 */
public class UmieszczenieModel {
    private Long ID;
    private DoubleProperty iloscWLokalizacji;
    private SimpleObjectProperty<TowarModel> towar;
    private SimpleObjectProperty<LokalizacjaModel> lokalizacja;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
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

    /**
     * metoda mapowania z obiektu transferowego do obiektu modelowego
     * @param umieszczenieTO wejściowy obiekt transferowy
     * @return wyjściowe obiekt modelu
     */
    public static UmieszczenieModel fromUmieszenieTo(UmieszczenieTO umieszczenieTO) {
        UmieszczenieModel umieszczenieModel = new UmieszczenieModel();
        umieszczenieModel.ID = umieszczenieTO.getID();
        umieszczenieModel.iloscWLokalizacji = new SimpleDoubleProperty(umieszczenieTO.getIloscWLokalizacji());
        umieszczenieModel.lokalizacja = new SimpleObjectProperty<>(LokalizacjaModel.fromLokalizacjaTo(umieszczenieTO.getLokalizacja()));
        umieszczenieModel.towar = new SimpleObjectProperty<>(TowarModel.fromTowarTo(umieszczenieTO.getTowar()));
        return umieszczenieModel;
    }
}
