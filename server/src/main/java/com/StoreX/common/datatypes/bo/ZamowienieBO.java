package com.StoreX.common.datatypes.bo;

import com.StoreX.persistence.entity.PozycjaZamowienia;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class ZamowienieBO {
    private int ID;
    private String kod;
    private Date dataZlozenia;
    private List<PozycjaZamowieniaBO> pozycjeZamowienia;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getKod() {
        return kod;
    }

    public void setKod(String kod) {
        this.kod = kod;
    }

    public Date getDataZlozenia() {
        return dataZlozenia;
    }

    public void setDataZlozenia(Date dataZlozenia) {
        this.dataZlozenia = dataZlozenia;
    }

    public List<PozycjaZamowieniaBO> getPozycjeZamowienia() {
        return pozycjeZamowienia;
    }

    public void setPozycjeZamowienia(List<PozycjaZamowieniaBO> pozycjeZamowienia) {
        this.pozycjeZamowienia = pozycjeZamowienia;
    }
}
