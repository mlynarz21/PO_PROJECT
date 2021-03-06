package com.crashcourse.restclient.model;


import com.crashcourse.restclient.datatype.ZamowienieZakupuTO;
import com.crashcourse.restclient.datatype.enumeration.StatusDostawy;
import com.crashcourse.restclient.datatype.enumeration.TypOdbioru;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.Date;

/**
 * klasa ZamowienieZakupu modelowa - używana w warstwie prezentacji
 */
public class ZamowienieZakupuModel extends ZamowienieModel{

    private SimpleObjectProperty<StatusDostawy> status;
    private SimpleObjectProperty<KlientModel> klient;
    private ObjectProperty<Date> terminRealizacji;
    private SimpleObjectProperty<TypOdbioru> typOdbioru;

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

    public SimpleObjectProperty<StatusDostawy> statusProperty() {
        return status;
    }

    public void setStatus(StatusDostawy status) {
        this.status.set(status);
    }

    public SimpleObjectProperty<KlientModel> klientProperty() {
        return klient;
    }

    public void setKlient(KlientModel klient) {
        this.klient.set(klient);
    }

    public ObjectProperty<Date> getTerminRealizacji() {
        return terminRealizacji;
    }

    public void setTerminRealizacji(ObjectProperty<Date> terminRealizacji) {
        terminRealizacji =terminRealizacji;
    }

    public SimpleObjectProperty<TypOdbioru> getTypOdbioru() {
        return typOdbioru;
    }

    public void setTypOdbioru(SimpleObjectProperty<TypOdbioru> typOdbioru) {
        this.typOdbioru = typOdbioru;
    }

    /**
     * metoda mapowania z obiektu transferowego do obiektu modelowego
     * @param zamowienieZakupuTO wejściowy obiekt transferowy
     * @return wyjściowe obiekt modelu
     */
    public static ZamowienieZakupuModel fromZamowienieZakupuTo(ZamowienieZakupuTO zamowienieZakupuTO) {
        ZamowienieZakupuModel zamowienieZakupuModel = new ZamowienieZakupuModel();
        if(zamowienieZakupuTO.getKlient()!=null)
            zamowienieZakupuModel.klient = new SimpleObjectProperty<>(KlientModel.fromKlientTo(zamowienieZakupuTO.getKlient()));
        zamowienieZakupuModel.status = new SimpleObjectProperty<>(zamowienieZakupuTO.getStatus());
        zamowienieZakupuModel.setDataZlozenia(new SimpleObjectProperty<Date>(zamowienieZakupuTO.getDataZlozenia()));
        zamowienieZakupuModel.setID(zamowienieZakupuTO.getID());
        zamowienieZakupuModel.setKod(new SimpleStringProperty(zamowienieZakupuTO.getKod()));
        zamowienieZakupuModel.terminRealizacji = new SimpleObjectProperty<Date>(zamowienieZakupuTO.getTerminRealizacji());
        zamowienieZakupuModel.typOdbioru = new SimpleObjectProperty<>(zamowienieZakupuTO.getTypOdbioru());
        return zamowienieZakupuModel;
    }
}

