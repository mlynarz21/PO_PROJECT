package com.crashcourse.restclient.model;

import com.crashcourse.restclient.datatype.KategoriaTO;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class KategoriaModel {
    private Long ID;
    private StringProperty kategoria;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public StringProperty getKategoria() {
        return kategoria;
    }

    public void setKategoria(StringProperty kategoria) {
        this.kategoria = kategoria;
    }
    public static KategoriaModel fromKategoriaTo(KategoriaTO kategoriaTO) {
        KategoriaModel kategoriaModel = new KategoriaModel();
        kategoriaModel.ID = kategoriaTO.getID();
        kategoriaModel.kategoria = new SimpleStringProperty(kategoriaTO.getKategoria());
        return kategoriaModel;
    }
}
