package com.crashcourse.restclient.model;

import com.crashcourse.restclient.datatype.PozycjaZamowieniaTO;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;

import java.util.Date;
import java.util.List;

public abstract class ZamowienieModel {
    private int ID;
    private StringProperty kod;
    private StringProperty dataZlozenia;
    private ListProperty<PozycjaZamowieniaModel> pozycjeZamowienia;

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

    public StringProperty getDataZlozenia() {
        return dataZlozenia;
    }

    public void setDataZlozenia(StringProperty dataZlozenia) {
        this.dataZlozenia = dataZlozenia;
    }

    public ListProperty<PozycjaZamowieniaModel> getPozycjeZamowienia() {
        return pozycjeZamowienia;
    }

    public void setPozycjeZamowienia(ListProperty<PozycjaZamowieniaModel> pozycjeZamowienia) {
        this.pozycjeZamowienia = pozycjeZamowienia;
    }
}
