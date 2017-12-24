package com.crashcourse.restclient.model;


import com.crashcourse.restclient.datatype.ZamowienieZakupuTO;
import com.crashcourse.restclient.datatype.enumeration.StatusDostawy;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.Date;

public class ZamowienieZakupuModel extends ZamowienieModel{

    private SimpleObjectProperty<StatusDostawy> status;
    private SimpleObjectProperty<KlientModel> klient;

    public SimpleObjectProperty<StatusDostawy> getStatus() {
        return status;
    }

    public void setStatus(SimpleObjectProperty<StatusDostawy> status) {
        this.status = status;
    }

    public SimpleObjectProperty<KlientModel> getKlient() {
        return klient;
    }

    public void setKlient(SimpleObjectProperty<KlientModel> klient) {
        this.klient = klient;
    }

    public static ZamowienieZakupuModel fromZamowienieZakupuTo(ZamowienieZakupuTO zamowienieZakupuTO) {
        ZamowienieZakupuModel zamowienieZakupuModel = new ZamowienieZakupuModel();
        zamowienieZakupuModel.klient = new SimpleObjectProperty<>(KlientModel.fromKlientTo(zamowienieZakupuTO.getKlient()));
        zamowienieZakupuModel.status = new SimpleObjectProperty<>(zamowienieZakupuTO.getStatus());
        zamowienieZakupuModel.setDataZlozenia(new SimpleObjectProperty<Date>(zamowienieZakupuTO.getDataZlozenia()));
        zamowienieZakupuModel.setID(zamowienieZakupuTO.getID());
        zamowienieZakupuModel.setKod(new SimpleStringProperty(zamowienieZakupuTO.getKod()));
        zamowienieZakupuModel.setPozycjeZamowienia(zamowienieZakupuModel.getPozycjeZamowienia());
        return zamowienieZakupuModel;
    }
}

