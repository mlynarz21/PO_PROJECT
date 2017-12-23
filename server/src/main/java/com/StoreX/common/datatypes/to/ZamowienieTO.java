package com.StoreX.common.datatypes.to;

import com.StoreX.persistence.entity.PozycjaZamowienia;

import java.util.Date;
import java.util.List;

public abstract class ZamowienieTO {
    private int ID;
    private String kod;
    private Date dataZlozenia;
    private List<PozycjaZamowieniaTO> pozycjeZamowienia;

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

    public List<PozycjaZamowieniaTO> getPozycjeZamowienia() {
        return pozycjeZamowienia;
    }

    public void setPozycjeZamowienia(List<PozycjaZamowieniaTO> pozycjeZamowienia) {
        this.pozycjeZamowienia = pozycjeZamowienia;
    }
}
