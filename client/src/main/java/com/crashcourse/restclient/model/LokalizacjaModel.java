package com.crashcourse.restclient.model;

import com.crashcourse.restclient.datatype.LokalizacjaTO;
import javafx.beans.property.*;

public class LokalizacjaModel {
    private Long ID;
    private StringProperty kod;
    private IntegerProperty numerRzedu;
    private IntegerProperty numerRegalu;
    private IntegerProperty numerSektora;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public StringProperty getKod() {
        return kod;
    }

    public void setKod(StringProperty kod) {
        this.kod = kod;
    }

    public IntegerProperty getNumerRzedu() {
        return numerRzedu;
    }

    public void setNumerRzedu(IntegerProperty numerRzedu) {
        this.numerRzedu = numerRzedu;
    }

    public IntegerProperty getNumerRegalu() {
        return numerRegalu;
    }

    public void setNumerRegalu(IntegerProperty numerRegalu) {
        this.numerRegalu = numerRegalu;
    }

    public IntegerProperty getNumerSektora() {
        return numerSektora;
    }

    public void setNumerSektora(IntegerProperty numerSektora) {
        this.numerSektora = numerSektora;
    }

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

