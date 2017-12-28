package com.crashcourse.restclient.model;


import com.crashcourse.restclient.datatype.BilansTO;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.util.Date;

public class BilansModel {

    private Long ID;
    private ObjectProperty<Date> dataWykonania;
    private ObjectProperty<Date> dataBilansu;

    public Long getID() {
        return ID;
    }

    public ObjectProperty<Date> getDataWykonania() {
        return dataWykonania;
    }

    public ObjectProperty<Date> getDataBilansu() {
        return dataBilansu;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public void setDataWykonania(ObjectProperty<Date> dataWykonania) {
        this.dataWykonania = dataWykonania;
    }

    public void setDataBilansu(ObjectProperty<Date> dataBilansu) {
        this.dataBilansu = dataBilansu;
    }

    public static BilansModel fromBilansTo(BilansTO bilansTO) {
        BilansModel bilansModel = new BilansModel();
        bilansModel.ID=bilansTO.getID();
        bilansModel.dataBilansu= new SimpleObjectProperty<>(bilansTO.getDataBilansu());
        bilansModel.dataWykonania=new SimpleObjectProperty<>(bilansTO.getDataWykonania());
        return bilansModel;
    }
}
