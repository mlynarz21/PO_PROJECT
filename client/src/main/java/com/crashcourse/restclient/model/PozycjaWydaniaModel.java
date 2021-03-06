package com.crashcourse.restclient.model;

import com.crashcourse.restclient.datatype.PozycjaWydaniaTO;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;

/**
 * klasa PozycjaWydania modelowa - używana w warstwie prezentacji
 */
public class PozycjaWydaniaModel {
    private Long ID;
    private DoubleProperty ilosc;
    private SimpleObjectProperty<TowarModel> towar;
    private SimpleObjectProperty<WydanieZamowieniaModel> wydanieZamowienia;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public DoubleProperty getIlosc() {
        return ilosc;
    }

    public void setIlosc(DoubleProperty ilosc) {
        this.ilosc = ilosc;
    }

    public SimpleObjectProperty<TowarModel> getTowar() {
        return towar;
    }

    public void setTowar(SimpleObjectProperty<TowarModel> towar) {
        this.towar = towar;
    }

    public SimpleObjectProperty<WydanieZamowieniaModel> getWydanieZamowienia() {
        return wydanieZamowienia;
    }

    public void setWydanieZamowienia(SimpleObjectProperty<WydanieZamowieniaModel> wydanieZamowienia) {
        this.wydanieZamowienia = wydanieZamowienia;
    }

    /**
     * metoda mapowania z obiektu transferowego do obiektu modelowego
     * @param pozycjaWydaniaTO wejściowy obiekt transferowy
     * @return wyjściowe obiekt modelu
     */
    public static PozycjaWydaniaModel fromPozycjaWydaniaTo(PozycjaWydaniaTO pozycjaWydaniaTO) {
        PozycjaWydaniaModel pozycjaWydaniaModel = new PozycjaWydaniaModel();
        pozycjaWydaniaModel.wydanieZamowienia = new SimpleObjectProperty<>(WydanieZamowieniaModel.fromWydanieZamowieniaTo(pozycjaWydaniaTO.getWydanieZamowienia()));;
        pozycjaWydaniaModel.ID = pozycjaWydaniaTO.getID();
        pozycjaWydaniaModel.ilosc = new SimpleDoubleProperty(pozycjaWydaniaTO.getIlosc());
        pozycjaWydaniaModel.towar = new SimpleObjectProperty<>(TowarModel.fromTowarTo(pozycjaWydaniaTO.getTowar()));;
        return pozycjaWydaniaModel;
    }
}
