package com.crashcourse.restclient.model;

import com.crashcourse.restclient.datatype.BilansTO;
import com.crashcourse.restclient.datatype.TowarTO;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleObjectProperty;

public class PozycjaBilansuModel {
    private int ID;
    private DoubleProperty ilosc;
    private SimpleObjectProperty<TowarModel> towar;
    private SimpleObjectProperty<BilansModel> bilans;

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

    public SimpleObjectProperty<BilansModel> getBilans() {
        return bilans;
    }

    public void setBilans(SimpleObjectProperty<BilansModel> bilans) {
        this.bilans = bilans;
    }
}