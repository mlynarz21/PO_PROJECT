package com.crashcourse.restclient.model;

import com.crashcourse.restclient.datatype.PozycjaBilansuTO;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import java.util.Date;

public class BilansModel {

    private int ID;
    private ObjectProperty<Date> dataWykonania;
    private ObjectProperty<Date> dataBilansu;
    private SimpleListProperty<PozycjaBilansuModel> pozycjeBilansu = new SimpleListProperty<>();

    public int getID() {
        return ID;
    }

    public ObjectProperty<Date> getDataWykonania() {
        return dataWykonania;
    }

    public ObjectProperty<Date> getDataBilansu() {
        return dataBilansu;
    }

    public SimpleListProperty<PozycjaBilansuModel> getPozycjeBilansu() {
        return pozycjeBilansu;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setDataWykonania(ObjectProperty<Date> dataWykonania) {
        this.dataWykonania = dataWykonania;
    }

    public void setDataBilansu(ObjectProperty<Date> dataBilansu) {
        this.dataBilansu = dataBilansu;
    }

    public void setPozycjeBilansu(SimpleListProperty<PozycjaBilansuModel> pozycjeBilansu) {
        this.pozycjeBilansu = pozycjeBilansu;
    }
}
