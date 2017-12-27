package com.StoreX.common.datatypes.bo;

import com.StoreX.persistence.entity.PozycjaBilansu;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BilansBO {

    private Long ID;
    private Date dataWykonania;
    private Date dataBilansu;

    public Long getID() {
        return ID;
    }

    public Date getDataWykonania() {
        return dataWykonania;
    }

    public Date getDataBilansu() {
        return dataBilansu;
    }


    public void setID(Long ID) {
        this.ID = ID;
    }

    public void setDataWykonania(Date dataWykonania) {
        this.dataWykonania = dataWykonania;
    }

    public void setDataBilansu(Date dataBilansu) {
        this.dataBilansu = dataBilansu;
    }

}
