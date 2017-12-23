package com.crashcourse.restclient.model;

import com.crashcourse.restclient.datatype.WydanieZamowieniaTO;
import com.crashcourse.restclient.datatype.ZamowienieDostawyTO;
import com.crashcourse.restclient.datatype.ZamowienieZakupuTO;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.Date;

public class WydanieZamowieniaModel {
    private int ID;
    private ObjectProperty<Date> data;
    private SimpleObjectProperty<ZamowienieZakupuModel> zamowienie;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public ObjectProperty<Date> getData() {
        return data;
    }

    public void setData(ObjectProperty<Date> data) {
        this.data = data;
    }

    public SimpleObjectProperty<ZamowienieZakupuModel> getZamowienie() {
        return zamowienie;
    }

    public void setZamowienie(SimpleObjectProperty<ZamowienieZakupuModel> zamowienie) {
        this.zamowienie = zamowienie;
    }

    public static WydanieZamowieniaModel fromWydanieZamowieniaTo(WydanieZamowieniaTO wydanieZamowieniaTO) {
        WydanieZamowieniaModel wydanieZamowieniaModel = new WydanieZamowieniaModel();
        wydanieZamowieniaModel.ID = wydanieZamowieniaTO.getID();
        wydanieZamowieniaModel.data = new SimpleObjectProperty<>(wydanieZamowieniaTO.getData());
        wydanieZamowieniaModel.zamowienie = new SimpleObjectProperty<>(ZamowienieZakupuModel.fromZamowienieZakupuTo(wydanieZamowieniaTO.getZamowienie()));
        return wydanieZamowieniaModel;
    }
}
