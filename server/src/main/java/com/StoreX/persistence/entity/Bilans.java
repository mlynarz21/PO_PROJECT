package com.StoreX.persistence.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Bilans {

    @Id
    @GeneratedValue
    private Long ID;

    private Date dataWykonania;

    private Date dataBilansu;



    public Bilans(){

    }
    public Bilans(Long ID, Date dataWykonania, Date dataBilansu){
        this.ID=ID;
        this.dataWykonania=dataWykonania;
        this.dataBilansu=dataBilansu;
    }

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
