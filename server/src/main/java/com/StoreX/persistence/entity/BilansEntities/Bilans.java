package com.StoreX.persistence.entity.BilansEntities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

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
