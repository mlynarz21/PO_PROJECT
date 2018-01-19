package com.crashcourse.restclient.model;

import com.crashcourse.restclient.datatype.WydanieZamowieniaTO;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.util.Date;

/**
 * klasa WydanieZamowienia modelowa - używana w warstwie prezentacji
 */
public class WydanieZamowieniaModel {
    private Long ID;
    private ObjectProperty<Date> data;
    private SimpleObjectProperty<ZamowienieZakupuModel> zamowienie;

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

    public SimpleObjectProperty<ZamowienieZakupuModel> getZamowienie() {
        return zamowienie;
    }

    public void setZamowienie(SimpleObjectProperty<ZamowienieZakupuModel> zamowienie) {
        this.zamowienie = zamowienie;
    }

    /**
     * metoda mapowania z obiektu transferowego do obiektu modelowego
     * @param wydanieZamowieniaTO wejściowy obiekt transferowy
     * @return wyjściowe obiekt modelu
     */
    public static WydanieZamowieniaModel fromWydanieZamowieniaTo(WydanieZamowieniaTO wydanieZamowieniaTO) {
        WydanieZamowieniaModel wydanieZamowieniaModel = new WydanieZamowieniaModel();
        wydanieZamowieniaModel.ID = wydanieZamowieniaTO.getID();
        wydanieZamowieniaModel.data = new SimpleObjectProperty<>(wydanieZamowieniaTO.getData());
        wydanieZamowieniaModel.zamowienie = new SimpleObjectProperty<>(ZamowienieZakupuModel.fromZamowienieZakupuTo(wydanieZamowieniaTO.getZamowienie()));
        return wydanieZamowieniaModel;
    }
}
