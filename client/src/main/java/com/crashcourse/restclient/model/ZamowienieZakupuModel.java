package com.crashcourse.restclient.model;


import com.crashcourse.restclient.datatype.KlientTO;
import com.crashcourse.restclient.datatype.ZamowienieTO;
import com.crashcourse.restclient.datatype.enumeration.StatusDostawy;
import javafx.beans.property.SimpleObjectProperty;

public class ZamowienieZakupuModel extends ZamowienieTO{

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
}

