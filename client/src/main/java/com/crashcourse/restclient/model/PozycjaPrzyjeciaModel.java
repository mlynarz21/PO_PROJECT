package com.crashcourse.restclient.model;

import com.crashcourse.restclient.datatype.PrzyjecieZamowieniaTO;
import com.crashcourse.restclient.datatype.TowarTO;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleObjectProperty;

public class PozycjaPrzyjeciaModel {
    private int ID;
    private DoubleProperty ilosc;
    private SimpleObjectProperty<TowarModel> towar;
    private SimpleObjectProperty<PrzyjecieZamowieniaModel> przyjecieZamowienia;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
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
}
