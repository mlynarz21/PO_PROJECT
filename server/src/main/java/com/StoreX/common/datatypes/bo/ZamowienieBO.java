package com.StoreX.common.datatypes.bo;

import com.StoreX.persistence.entity.PozycjaZamowienia;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class ZamowienieBO {
    private Long ID;
    private String kod;
    private Date dataZlozenia;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
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
}
