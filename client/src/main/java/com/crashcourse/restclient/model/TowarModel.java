package com.crashcourse.restclient.model;

import com.crashcourse.restclient.datatype.JednostkaTO;
import com.crashcourse.restclient.datatype.KategoriaTO;
import com.crashcourse.restclient.datatype.UmieszczenieTO;
import javafx.beans.property.*;

import java.util.List;

public class TowarModel {
    private int ID;
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
    private ListProperty<UmieszczenieModel> umieszczenia;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
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

    public ListProperty<UmieszczenieModel> getUmieszczenia() {
        return umieszczenia;
    }

    public void setUmieszczenia(ListProperty<UmieszczenieModel> umieszczenia) {
        this.umieszczenia = umieszczenia;
    }
}
