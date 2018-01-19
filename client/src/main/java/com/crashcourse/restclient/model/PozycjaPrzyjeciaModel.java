package com.crashcourse.restclient.model;

import com.crashcourse.restclient.datatype.PozycjaPrzyjeciaTO;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;

/**
 * klasa PozycjaPrzyjecia modelowa - używana w warstwie prezentacji
 */
public class PozycjaPrzyjeciaModel {
    private Long ID;
    private DoubleProperty ilosc;
    private SimpleObjectProperty<TowarModel> towar;
    private SimpleObjectProperty<PrzyjecieZamowieniaModel> przyjecieZamowienia;

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

    public SimpleObjectProperty<PrzyjecieZamowieniaModel> getPrzyjecieZamowienia() {
        return przyjecieZamowienia;
    }

    public void setPrzyjecieZamowienia(SimpleObjectProperty<PrzyjecieZamowieniaModel> przyjecieZamowienia) {
        this.przyjecieZamowienia = przyjecieZamowienia;
    }

    public static PozycjaPrzyjeciaModel fromPozycjaPrzyjeciaTo(PozycjaPrzyjeciaTO pozycjaPrzyjeciaTO) {
        PozycjaPrzyjeciaModel pozycjaPrzyjeciaModel = new PozycjaPrzyjeciaModel();
        pozycjaPrzyjeciaModel.przyjecieZamowienia = new SimpleObjectProperty<>(PrzyjecieZamowieniaModel.fromZamowienieZakupuTo(pozycjaPrzyjeciaTO.getPrzyjecieZamowienia()));;
        pozycjaPrzyjeciaModel.ID = pozycjaPrzyjeciaTO.getID();
        pozycjaPrzyjeciaModel.ilosc = new SimpleDoubleProperty(pozycjaPrzyjeciaTO.getIlosc());
        pozycjaPrzyjeciaModel.towar = new SimpleObjectProperty<>(TowarModel.fromTowarTo(pozycjaPrzyjeciaTO.getTowar()));;
        return pozycjaPrzyjeciaModel;
    }
}
