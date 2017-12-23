package com.crashcourse.restclient.model;

import com.crashcourse.restclient.datatype.TowarTO;
import com.crashcourse.restclient.datatype.WydanieZamowieniaTO;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleObjectProperty;

public class PozycjaWydaniaModel {
    private int ID;
    private DoubleProperty ilosc;
    private SimpleObjectProperty<TowarModel> towar;
    private SimpleObjectProperty<WydanieZamowieniaModel> wydanieZamowienia;

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

    public SimpleObjectProperty<WydanieZamowieniaModel> getWydanieZamowienia() {
        return wydanieZamowienia;
    }

    public void setWydanieZamowienia(SimpleObjectProperty<WydanieZamowieniaModel> wydanieZamowienia) {
        this.wydanieZamowienia = wydanieZamowienia;
    }
}
