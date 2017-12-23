package com.crashcourse.restclient.datatype;

import com.crashcourse.restclient.model.JednostkaModel;
import com.crashcourse.restclient.model.KategoriaModel;
import javafx.beans.property.SimpleStringProperty;

public class KategoriaTO {
    private int ID;
    private String kategoria;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getKategoria() {
        return kategoria;
    }

    public void setKategoria(String kategoria) {
        this.kategoria = kategoria;
    }
}
