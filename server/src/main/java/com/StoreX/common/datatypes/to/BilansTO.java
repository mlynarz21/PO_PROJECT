package com.StoreX.common.datatypes.to;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * klasa Bilans obiektu transferowego - używanego w komunikacji między serwerem a klientem
 */
public class BilansTO {

    private Long ID;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private Date dataWykonania;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
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
