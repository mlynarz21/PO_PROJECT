package com.crashcourse.restclient.model;

import com.crashcourse.restclient.datatype.KategoriaTO;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * klasa Kategoria modelowa - używana w warstwie prezentacji
 */
public class KategoriaModel {
    private Long ID;
    private StringProperty kategoria;

    /**
     * pobiera ID kategorii
     * @return ID kategorii
     */
    public Long getID() {
        return ID;
    }

    /**
     * ustawia ID kategorii
     * @param ID nowe ID
     */
    public void setID(Long ID) {
        this.ID = ID;
    }

    /**
     * pobiera kategorię
     * @return kategoria
     */
    public StringProperty getKategoria() {
        return kategoria;
    }

    /**
     * ustawia kateogorię
     * @param kategoria nowa kategoria
     */
    public void setKategoria(StringProperty kategoria) {
        this.kategoria = kategoria;
    }

    /**
     * metoda mapowania z obiektu transferowego do obiektu modelowego
     * @param kategoriaTO wejściowy obiekt transferowy
     * @return wyjściowe obiekt modelu
     */
    public static KategoriaModel fromKategoriaTo(KategoriaTO kategoriaTO) {
        KategoriaModel kategoriaModel = new KategoriaModel();
        kategoriaModel.ID = kategoriaTO.getID();
        kategoriaModel.kategoria = new SimpleStringProperty(kategoriaTO.getKategoria());
        return kategoriaModel;
    }
}
