package com.crashcourse.restclient.model;

import com.crashcourse.restclient.datatype.ZamowienieDostawyTO;
import com.crashcourse.restclient.datatype.enumeration.StatusWydania;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.Date;

public class ZamowienieDostawyModel extends ZamowienieModel{

    private SimpleObjectProperty<StatusWydania> status;

    public SimpleObjectProperty<StatusWydania> getStatus() {
        return status;
    }

    public void setStatus(SimpleObjectProperty<StatusWydania> status) {
        this.status = status;
    }

    public static ZamowienieDostawyModel fromZamowienieDostawyTo(ZamowienieDostawyTO zamowienieDostawyTO) {
        ZamowienieDostawyModel zamowienieDostawyModel = new ZamowienieDostawyModel();
        zamowienieDostawyModel.status = new SimpleObjectProperty<>(zamowienieDostawyTO.getStatus());
        zamowienieDostawyModel.setDataZlozenia(new SimpleObjectProperty<Date>(zamowienieDostawyTO.getDataZlozenia()));
        zamowienieDostawyModel.setID(zamowienieDostawyTO.getID());
        zamowienieDostawyModel.setKod(new SimpleStringProperty(zamowienieDostawyTO.getKod()));
        return zamowienieDostawyModel;
    }
}
