package com.crashcourse.restclient.model;

import com.crashcourse.restclient.datatype.TowarTO;
import com.crashcourse.restclient.datatype.ZamowienieTO;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleObjectProperty;

public class PozycjaZamowieniaModel {
    private int ID;
    private DoubleProperty ilosc;
    private DoubleProperty zrealizowano;
    private SimpleObjectProperty<TowarModel> towar;
    private SimpleObjectProperty<ZamowienieModel> zamowienie;

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

    public SimpleObjectProperty<ZamowienieModel> getZamowienie() {
        return zamowienie;
    }

    public void setZamowienie(SimpleObjectProperty<ZamowienieModel> zamowienie) {
        this.zamowienie = zamowienie;
    }

    public DoubleProperty getZrealizowano() {
        return zrealizowano;
    }

    public void setZrealizowano(DoubleProperty zrealizowano) {
        this.zrealizowano = zrealizowano;
    }
}
