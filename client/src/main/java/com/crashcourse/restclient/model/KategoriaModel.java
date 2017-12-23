package com.crashcourse.restclient.model;

import javafx.beans.property.StringProperty;

public class KategoriaModel {
    private int ID;
    private StringProperty kategoria;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public StringProperty getKategoria() {
        return kategoria;
    }

    public void setKategoria(StringProperty kategoria) {
        this.kategoria = kategoria;
    }
}
