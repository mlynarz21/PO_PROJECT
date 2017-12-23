package com.crashcourse.restclient.model;


import com.crashcourse.restclient.datatype.BilansTO;
import com.crashcourse.restclient.datatype.PozycjaBilansuTO;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BilansModel {

    private int ID;
    private ObjectProperty<Date> dataWykonania;
    private ObjectProperty<Date> dataBilansu;
    private List<PozycjaBilansuTO> pozycjeBilansu = new ArrayList<>();

    public int getID() {
        return ID;
    }

    public ObjectProperty<Date> getDataWykonania() {
        return dataWykonania;
    }

    public ObjectProperty<Date> getDataBilansu() {
        return dataBilansu;
    }

    public List<PozycjaBilansuTO> getPozycjeBilansu() {
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

    public void setPozycjeBilansu(List<PozycjaBilansuTO> pozycjeBilansu) {
        this.pozycjeBilansu = pozycjeBilansu;
    }

    public static BilansModel fromBilansTo(BilansTO bilansTO) {
        BilansModel bilansModel = new BilansModel();
        bilansModel.ID=bilansTO.getID();
        bilansModel.dataBilansu= new SimpleObjectProperty<>(bilansTO.getDataBilansu());
        bilansModel.dataWykonania=new SimpleObjectProperty<>(bilansTO.getDataWykonania());
        bilansModel.pozycjeBilansu=bilansTO.getPozycjeBilansu();
        return bilansModel;
    }
}
