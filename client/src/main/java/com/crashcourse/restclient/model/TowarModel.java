package com.crashcourse.restclient.model;

import com.crashcourse.restclient.datatype.TowarTO;
import javafx.beans.property.*;

/**
 * klasa Towar modelowa - używana w warstwie prezentacji
 */
public class TowarModel {
    private Long ID;
    private StringProperty nazwa;
    private StringProperty kod;
    private DoubleProperty ilostan;
    private DoubleProperty iloscMinimalna;
    private DoubleProperty iloscZablokowana;
    private IntegerProperty czasZalegania;
    private BooleanProperty zalega;
    private BooleanProperty potrzebujeZamowienia;
    private SimpleObjectProperty<JednostkaModel> jednostka;
    private SimpleObjectProperty<KategoriaModel> kategoria;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public StringProperty getNazwa() {
        return nazwa;
    }

    public void setNazwa(StringProperty nazwa) {
        this.nazwa = nazwa;
    }

    public StringProperty getKod() {
        return kod;
    }

    public void setKod(StringProperty kod) {
        this.kod = kod;
    }

    public DoubleProperty getIlostan() {
        return ilostan;
    }

    public void setIlostan(DoubleProperty ilostan) {
        this.ilostan = ilostan;
    }

    public IntegerProperty getCzasZalegania() {
        return czasZalegania;
    }

    public void setCzasZalegania(IntegerProperty czasZalegania) {
        this.czasZalegania = czasZalegania;
    }

    public DoubleProperty getIloscZablokowana() {
        return iloscZablokowana;
    }

    public void setIloscZablokowana(DoubleProperty iloscZablokowana) {
        this.iloscZablokowana = iloscZablokowana;
    }

    public BooleanProperty isZalega() {
        return zalega;
    }

    public void setZalega(BooleanProperty zalega) {
        this.zalega = zalega;
    }

    public BooleanProperty isPotrzebujeZamowienia() {
        return potrzebujeZamowienia;
    }

    public void setPotrzebujeZamowienia(BooleanProperty potrzebujeZamowienia) {
        this.potrzebujeZamowienia = potrzebujeZamowienia;
    }

    public DoubleProperty getIloscMinimalna() {
        return iloscMinimalna;
    }

    public void setIloscMinimalna(DoubleProperty iloscMinimalna) {
        this.iloscMinimalna = iloscMinimalna;
    }

    public SimpleObjectProperty<JednostkaModel> getJednostka() {
        return jednostka;
    }

    public void setJednostka(SimpleObjectProperty<JednostkaModel> jednostka) {
        this.jednostka = jednostka;
    }

    public SimpleObjectProperty<KategoriaModel> getKategoria() {
        return kategoria;
    }

    public void setKategoria(SimpleObjectProperty<KategoriaModel> kategoria) {
        this.kategoria = kategoria;
    }

    public static TowarModel fromTowarTo(TowarTO towarTO) {
        TowarModel towarModel = new TowarModel();
        towarModel.ID = towarTO.getID();
        towarModel.czasZalegania = new SimpleIntegerProperty(towarTO.getCzasZalegania());
        towarModel.iloscMinimalna = new SimpleDoubleProperty(towarTO.getIloscMinimalna());
        towarModel.iloscZablokowana = new SimpleDoubleProperty(towarTO.getIloscZablokowana());
        towarModel.ilostan = new SimpleDoubleProperty(towarTO.getIlostan());
        towarModel.jednostka = new SimpleObjectProperty<>(JednostkaModel.fromJednostkaTo(towarTO.getJednostka()));
        towarModel.kategoria = new SimpleObjectProperty<>(KategoriaModel.fromKategoriaTo(towarTO.getKategoria()));
        towarModel.kod = new SimpleStringProperty(towarTO.getKod());
        towarModel.potrzebujeZamowienia = new SimpleBooleanProperty(towarTO.isPotrzebujeZamowienia());
        towarModel.nazwa = new SimpleStringProperty(towarTO.getNazwa());
        towarModel.zalega = new SimpleBooleanProperty(towarTO.isZalega());
        return towarModel;
    }
}
