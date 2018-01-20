package com.crashcourse.restclient.model;

import com.crashcourse.restclient.datatype.JednostkaTO;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * klasa Jednostka modelowa - używana w warstwie prezentacji
 */
public class JednostkaModel {
    private Long ID;
    private StringProperty rodzaj;

    /**
     * pobiera ID jednostki
     * @return ID jednostki
     */
    public Long getID() {
        return ID;
    }

    /**
     * ustawia ID jednostki
     * @param ID nowe ID
     */
    public void setID(Long ID) {
        this.ID = ID;
    }

    /**
     * pobiera rodzaj jednostki
     * @return rodzaj jednotki
     */
    public StringProperty getRodzaj() {
        return rodzaj;
    }

    /**
     * ustawia rodzaj jednostki
     * @param rodzaj nowy rodzaj do ustawienia
     */
    public void setRodzaj(StringProperty rodzaj) {
        this.rodzaj = rodzaj;
    }

    /**
     * metoda mapowania z obiektu transferowego do obiektu modelowego
     * @param jednostkaTO wejściowy obiekt transferowy
     * @return wyjściowe obiekt modelu
     */
    public static JednostkaModel fromJednostkaTo(JednostkaTO jednostkaTO) {
        JednostkaModel jednostkaModel = new JednostkaModel();
        jednostkaModel.ID = jednostkaTO.getID();
        jednostkaModel.rodzaj = new SimpleStringProperty(jednostkaTO.getRodzaj());
        return jednostkaModel;
    }
}
