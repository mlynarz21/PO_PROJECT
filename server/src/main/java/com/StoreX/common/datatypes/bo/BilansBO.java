package com.StoreX.common.datatypes.bo;

import com.StoreX.persistence.entity.PozycjaBilansu;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BilansBO {

    private int ID;
    private Date dataWykonania;
    private Date dataBilansu;
    private List<PozycjaBilansuBO> pozycjeBilansu = new ArrayList<>();

    public int getID() {
        return ID;
    }

    public Date getDataWykonania() {
        return dataWykonania;
    }

    public Date getDataBilansu() {
        return dataBilansu;
    }

    public List<PozycjaBilansuBO> getPozycjeBilansu() {
        return pozycjeBilansu;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setDataWykonania(Date dataWykonania) {
        this.dataWykonania = dataWykonania;
    }

    public void setDataBilansu(Date dataBilansu) {
        this.dataBilansu = dataBilansu;
    }

    public void setPozycjeBilansu(List<PozycjaBilansuBO> pozycjeBilansu) {
        this.pozycjeBilansu = pozycjeBilansu;
    }
}
