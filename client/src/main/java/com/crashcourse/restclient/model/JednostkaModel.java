package com.crashcourse.restclient.model;

import com.crashcourse.restclient.datatype.JednostkaTO;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class JednostkaModel {
    private Long ID;
    private StringProperty rodzaj;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public StringProperty getRodzaj() {
        return rodzaj;
    }

    public void setRodzaj(StringProperty rodzaj) {
        this.rodzaj = rodzaj;
    }

    public static JednostkaModel fromJednostkaTo(JednostkaTO jednostkaTO) {
        JednostkaModel jednostkaModel = new JednostkaModel();
        jednostkaModel.ID = jednostkaTO.getID();
        jednostkaModel.rodzaj = new SimpleStringProperty(jednostkaTO.getRodzaj());
        return jednostkaModel;
    }
}
