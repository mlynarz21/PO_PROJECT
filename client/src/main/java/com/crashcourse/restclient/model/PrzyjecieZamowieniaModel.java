package com.crashcourse.restclient.model;

import com.crashcourse.restclient.datatype.PrzyjecieZamowieniaTO;
import com.crashcourse.restclient.datatype.WydanieZamowieniaTO;
import com.crashcourse.restclient.datatype.ZamowienieDostawyTO;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.util.Date;

public class PrzyjecieZamowieniaModel {
    private int ID;
    private ObjectProperty<Date> data;
    private SimpleObjectProperty<ZamowienieDostawyModel> zamowienie;

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

    public SimpleObjectProperty<ZamowienieDostawyModel> getZamowienie() {
        return zamowienie;
    }

    public void setZamowienie(SimpleObjectProperty<ZamowienieDostawyModel> zamowienie) {
        this.zamowienie = zamowienie;
    }

    public static PrzyjecieZamowieniaModel fromZamowienieZakupuTo(PrzyjecieZamowieniaTO przyjecieZamowieniaTO) {
        PrzyjecieZamowieniaModel przyjecieZamowieniaModel = new PrzyjecieZamowieniaModel();
        przyjecieZamowieniaModel.ID = przyjecieZamowieniaTO.getID();
        przyjecieZamowieniaModel.data = new SimpleObjectProperty<>(przyjecieZamowieniaTO.getData());
        przyjecieZamowieniaModel.zamowienie = new SimpleObjectProperty<>(ZamowienieDostawyModel.fromZamowienieDostawyTo(przyjecieZamowieniaTO.getZamowienie()));
        return przyjecieZamowieniaModel;
    }
}
