package com.crashcourse.restclient.model;

import com.crashcourse.restclient.datatype.*;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;

public class PozycjaZamowieniaModel {
    private Long ID;
    private DoubleProperty ilosc;
    private DoubleProperty zrealizowano;
    private SimpleObjectProperty<TowarModel> towar;
    private SimpleObjectProperty<ZamowienieModel> zamowienie;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public DoubleProperty getIlosc() {
        return ilosc;
    }

    public void setIlosc(DoubleProperty ilosc) {
        this.ilosc = ilosc;
    }

    public SimpleObjectProperty<TowarModel> getTowar() {
        return towar;
    }

    public void setTowar(SimpleObjectProperty<TowarModel> towar) {
        this.towar = towar;
    }

    public SimpleObjectProperty<ZamowienieModel> getZamowienie() {
        return zamowienie;
    }

    public void setZamowienie(SimpleObjectProperty<ZamowienieModel> zamowienie) {
        this.zamowienie = zamowienie;
    }

    public DoubleProperty getZrealizowano() {
        return zrealizowano;
    }

    public void setZrealizowano(DoubleProperty zrealizowano) {
        this.zrealizowano = zrealizowano;
    }

    public static PozycjaZamowieniaModel fromPozycjaZamowieniaTo(PozycjaZamowieniaTO pozycjaZamowieniaTO) {
        PozycjaZamowieniaModel pozycjaZamowieniaModel = new PozycjaZamowieniaModel();
        if(pozycjaZamowieniaTO.getZamowienie() instanceof ZamowienieDostawyTO)
            pozycjaZamowieniaModel.zamowienie = new SimpleObjectProperty<>(ZamowienieDostawyModel.fromZamowienieDostawyTo((ZamowienieDostawyTO) pozycjaZamowieniaTO.getZamowienie()));
        else pozycjaZamowieniaModel.zamowienie = new SimpleObjectProperty<>(ZamowienieZakupuModel.fromZamowienieZakupuTo((ZamowienieZakupuTO) pozycjaZamowieniaTO.getZamowienie()));
        pozycjaZamowieniaModel.ID = pozycjaZamowieniaTO.getID();
        pozycjaZamowieniaModel.ilosc = new SimpleDoubleProperty(pozycjaZamowieniaTO.getIlosc());
        pozycjaZamowieniaModel.towar = new SimpleObjectProperty<>(TowarModel.fromTowarTo(pozycjaZamowieniaTO.getTowar()));;
        pozycjaZamowieniaModel.zrealizowano = new SimpleDoubleProperty(pozycjaZamowieniaTO.getZrealizowano());
        return pozycjaZamowieniaModel;
    }
}
