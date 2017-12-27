package com.crashcourse.restclient.model;

import com.crashcourse.restclient.datatype.PozycjaZamowieniaTO;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;

import java.util.Date;
import java.util.List;

public abstract class ZamowienieModel {
    private Long ID;
    private StringProperty kod;
    private ObjectProperty<Date> dataZlozenia;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
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
}
