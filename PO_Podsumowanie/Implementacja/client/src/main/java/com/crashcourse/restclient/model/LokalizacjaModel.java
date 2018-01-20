package com.crashcourse.restclient.model;

import com.crashcourse.restclient.datatype.LokalizacjaTO;
import javafx.beans.property.*;

/**
 * klasa Lokalizacja modelowa - używana w warstwie prezentacji
 */
public class LokalizacjaModel {
    private Long ID;
    private StringProperty kod;
    private IntegerProperty numerRzedu;
    private IntegerProperty numerRegalu;
    private IntegerProperty numerSektora;

    /**
     * pobiera ID lokalizacji
     * @return ID lokalizacji
     */
    public Long getID() {
        return ID;
    }

    /**
     * ustawia ID lokalizacji
     * @param ID nowe ID
     */
    public void setID(Long ID) {
        this.ID = ID;
    }

    /**
     * pobiera kod lokalizacji
     * @return kod lokalizacji
     */
    public StringProperty getKod() {
        return kod;
    }

    /**
     * ustawia kod dla lokalizacji
     * @param kod nowy kod lokalizacji
     */
    public void setKod(StringProperty kod) {
        this.kod = kod;
    }

    /**
     * pobiera numer rzędu lokalizacji
     * @return numer rzędu
     */
    public IntegerProperty getNumerRzedu() {
        return numerRzedu;
    }

    /**
     * ustawia numer rzędu lokalizacji
     * @param numerRzedu nowy numer rzędu
     */
    public void setNumerRzedu(IntegerProperty numerRzedu) {
        this.numerRzedu = numerRzedu;
    }

    /**
     * pobiera numer regału
     * @return numer regału lokalizacji
     */
    public IntegerProperty getNumerRegalu() {
        return numerRegalu;
    }

    /**
     * ustawia numer regału
     * @param numerRegalu nowy numer regału
     */
    public void setNumerRegalu(IntegerProperty numerRegalu) {
        this.numerRegalu = numerRegalu;
    }

    /**
     * pobiera numer sektora
     * @return numer sektora lokalizacji
     */
    public IntegerProperty getNumerSektora() {
        return numerSektora;
    }

    /**
     * ustawia numer sektora lokalizacji
     * @param numerSektora nowy numer sektora
     */
    public void setNumerSektora(IntegerProperty numerSektora) {
        this.numerSektora = numerSektora;
    }

    /**
     * metoda mapowania z obiektu transferowego do obiektu modelowego
     * @param lokalizacjaTO wejściowy obiekt transferowy
     * @return wyjściowe obiekt modelu
     */
    public static LokalizacjaModel fromLokalizacjaTo(LokalizacjaTO lokalizacjaTO) {
        LokalizacjaModel lokalizacjaModel = new LokalizacjaModel();
        lokalizacjaModel.ID = lokalizacjaTO.getID();
        lokalizacjaModel.kod = new SimpleStringProperty(lokalizacjaTO.getKod());
        lokalizacjaModel.numerRegalu = new SimpleIntegerProperty(lokalizacjaTO.getNumerRegalu());
        lokalizacjaModel.numerRzedu = new SimpleIntegerProperty(lokalizacjaTO.getNumerRzedu());
        lokalizacjaModel.numerSektora = new SimpleIntegerProperty(lokalizacjaTO.getNumerSektora());
        return lokalizacjaModel;
    }
}

