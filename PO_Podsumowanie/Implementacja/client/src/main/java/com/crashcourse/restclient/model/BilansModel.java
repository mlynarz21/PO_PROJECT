package com.crashcourse.restclient.model;


import com.crashcourse.restclient.datatype.BilansTO;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.util.Date;

/**
 * klasa Bilans modelowa - używana w warstwie prezentacji
 */
public class BilansModel {

    private Long ID;
    private ObjectProperty<Date> dataWykonania;
    private ObjectProperty<Date> dataBilansu;

    /**
     * pobiera ID bilansu
     * @return ID bilansu
     */
    public Long getID() {
        return ID;
    }

    /**
     * pobiera datę wykonania bilansu
     * @return data wykonania bilansu
     */
    public ObjectProperty<Date> getDataWykonania() {
        return dataWykonania;
    }

    /**
     * pobiera datę miesiąca bilansowanego
     * @return data miesiąca bilansowanego
     */
    public ObjectProperty<Date> getDataBilansu() {
        return dataBilansu;
    }

    /**
     * ustawia ID bilansu
     * @param ID nowe ID
     */
    public void setID(Long ID) {
        this.ID = ID;
    }

    /**
     * ustawia dateę wykonania bilansu
     * @param dataWykonania nowa data wykonania
     */
    public void setDataWykonania(ObjectProperty<Date> dataWykonania) {
        this.dataWykonania = dataWykonania;
    }

    /**
     * ustawia datę miesiąca bilansowanego
     * @param dataBilansu nowa data reprezentująca miesiąc bilansowany
     */
    public void setDataBilansu(ObjectProperty<Date> dataBilansu) {
        this.dataBilansu = dataBilansu;
    }

    /**
     * metoda mapowania z obiektu transferowego do obiektu modelowego
     * @param bilansTO wejściowy obiekt transferowy
     * @return wyjściowe obiekt modelu
     */
    public static BilansModel fromBilansTo(BilansTO bilansTO) {
        BilansModel bilansModel = new BilansModel();
        bilansModel.ID=bilansTO.getID();
        bilansModel.dataBilansu= new SimpleObjectProperty<>(bilansTO.getDataBilansu());
        bilansModel.dataWykonania=new SimpleObjectProperty<>(bilansTO.getDataWykonania());
        return bilansModel;
    }
}
