package com.crashcourse.restclient.model;

import javafx.beans.property.StringProperty;

public class JednostkaModel {
    private int ID;
    private StringProperty rodzaj;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public StringProperty getRodzaj() {
        return rodzaj;
    }

    public void setRodzaj(StringProperty rodzaj) {
        this.rodzaj = rodzaj;
    }
}
