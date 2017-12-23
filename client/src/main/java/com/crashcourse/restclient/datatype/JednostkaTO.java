package com.crashcourse.restclient.datatype;

import com.crashcourse.restclient.model.BilansModel;
import com.crashcourse.restclient.model.JednostkaModel;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.StringProperty;

public class JednostkaTO {
    private int ID;
    private String rodzaj;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getRodzaj() {
        return rodzaj;
    }

    public void setRodzaj(String rodzaj) {
        this.rodzaj = rodzaj;
    }
}
