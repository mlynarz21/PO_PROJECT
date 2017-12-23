package com.crashcourse.restclient.model;

import com.crashcourse.restclient.datatype.PozycjaZamowieniaTO;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.StringProperty;

import java.util.Date;
import java.util.List;

public abstract class ZamowienieModel {
    private int ID;
    private StringProperty kod;
    private ObjectProperty<Date> dataZlozenia;
    private List<PozycjaZamowieniaTO> pozycjeZamowienia;

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

    public ObjectProperty<Date> getDataZlozenia() {
        return dataZlozenia;
    }

    public void setDataZlozenia(ObjectProperty<Date> dataZlozenia) {
        this.dataZlozenia = dataZlozenia;
    }

    public List<PozycjaZamowieniaTO> getPozycjeZamowienia() {
        return pozycjeZamowienia;
    }

    public void setPozycjeZamowienia(List<PozycjaZamowieniaTO> pozycjeZamowienia) {
        this.pozycjeZamowienia = pozycjeZamowienia;
    }
}
