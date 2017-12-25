package com.StoreX.persistence.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Bilans {

    @Id
    @GeneratedValue
    private int ID;

    private Date dataWykonania;

    private Date dataBilansu;

    @OneToMany(mappedBy = "bilans")
    private List<PozycjaBilansu> pozycjeBilansu = new ArrayList<>();

    public Bilans(){

    }
    public Bilans(int ID, Date dataWykonania, Date dataBilansu){
        this.ID=ID;
        this.dataWykonania=dataWykonania;
        this.dataBilansu=dataBilansu;
    }

    public int getID() {
        return ID;
    }

    public Date getDataWykonania() {
        return dataWykonania;
    }

    public Date getDataBilansu() {
        return dataBilansu;
    }

    public List<PozycjaBilansu> getPozycjeBilansu() {
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

    public void setPozycjeBilansu(List<PozycjaBilansu> pozycjeBilansu) {
        this.pozycjeBilansu = pozycjeBilansu;
    }
}
