package com.crashcourse.restclient.model;

import com.crashcourse.restclient.datatype.PozycjaBilansuTO;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;

/**
 * klasa PozycjaBilansu modelowa - używana w warstwie prezentacji
 */
public class PozycjaBilansuModel {
    private Long ID;
    private DoubleProperty ilosc;
    private SimpleObjectProperty<TowarModel> towar;
    private SimpleObjectProperty<BilansModel> bilans;

    /**
     * pobiera ID pozycjiBilansu
     * @return ID pozycjiBilansu
     */
    public Long getID() {
        return ID;
    }

    /**
     * ustawia ID pozycjiBilansu
     * @param ID nowe ID
     */
    public void setID(Long ID) {
        this.ID = ID;
    }

    /**
     * pobiera aktualną ilość towaru w pozycji
     * @return ilość towaru
     */
    public DoubleProperty getIlosc() {
        return ilosc;
    }

    /**
     * ustawia ilość towaru w pozycji
     * @param ilosc nowa ilość towaru
     */
    public void setIlosc(DoubleProperty ilosc) {
        this.ilosc = ilosc;
    }

    /**
     * pobiera towar odnoszący się do pozycji
     * @return towar
     */
    public SimpleObjectProperty<TowarModel> getTowar() {
        return towar;
    }
    /**
     * ustawia towar dla pozycji bilansu
     * @param towar nowy towar
     */

    public void setTowar(SimpleObjectProperty<TowarModel> towar) {
        this.towar = towar;
    }

    /**
     * pobiera bilans związany z pozycją
     * @return bilans
     */
    public SimpleObjectProperty<BilansModel> getBilans() {
        return bilans;
    }

    /**
     * ustawia bilans dla pozycji
     * @param bilans nowy bilans
     */
    public void setBilans(SimpleObjectProperty<BilansModel> bilans) {
        this.bilans = bilans;
    }

    /**
     * metoda mapowania z obiektu transferowego do obiektu modelowego
     * @param pozycjaBilansuTO wejściowy obiekt transferowy
     * @return wyjściowe obiekt modelu
     */
    public static PozycjaBilansuModel fromPozycjaBilansuTo(PozycjaBilansuTO pozycjaBilansuTO) {
        PozycjaBilansuModel pozycjaBilansuModel = new PozycjaBilansuModel();
        pozycjaBilansuModel.bilans = new SimpleObjectProperty<>(BilansModel.fromBilansTo(pozycjaBilansuTO.getBilans()));;
        pozycjaBilansuModel.ID = pozycjaBilansuTO.getID();
        pozycjaBilansuModel.ilosc = new SimpleDoubleProperty(pozycjaBilansuTO.getIlosc());
        pozycjaBilansuModel.towar = new SimpleObjectProperty<>(TowarModel.fromTowarTo(pozycjaBilansuTO.getTowar()));;
        return pozycjaBilansuModel;
    }
}