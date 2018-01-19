package com.crashcourse.restclient.model;

import com.crashcourse.restclient.datatype.PrzyjecieZamowieniaTO;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.util.Date;

/**
 * klasa PrzyjecieZamowienia modelowa - używana w warstwie prezentacji
 */
public class PrzyjecieZamowieniaModel {
    private Long ID;
    private ObjectProperty<Date> data;
    private SimpleObjectProperty<ZamowienieDostawyModel> zamowienie;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
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

    /**
     * metoda mapowania z obiektu transferowego do obiektu modelowego
     * @param przyjecieZamowieniaTO wejściowy obiekt transferowy
     * @return wyjściowe obiekt modelu
     */
    public static PrzyjecieZamowieniaModel fromZamowienieZakupuTo(PrzyjecieZamowieniaTO przyjecieZamowieniaTO) {
        PrzyjecieZamowieniaModel przyjecieZamowieniaModel = new PrzyjecieZamowieniaModel();
        przyjecieZamowieniaModel.ID = przyjecieZamowieniaTO.getID();
        przyjecieZamowieniaModel.data = new SimpleObjectProperty<>(przyjecieZamowieniaTO.getData());
        przyjecieZamowieniaModel.zamowienie = new SimpleObjectProperty<>(ZamowienieDostawyModel.fromZamowienieDostawyTo(przyjecieZamowieniaTO.getZamowienie()));
        return przyjecieZamowieniaModel;
    }
}
