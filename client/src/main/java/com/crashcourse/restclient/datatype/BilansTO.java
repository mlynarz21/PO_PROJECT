package com.crashcourse.restclient.datatype;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BilansTO {

    private int ID;
    private Date dataWykonania;
    private Date dataBilansu;
    private List<PozycjaBilansuTO> pozycjeBilansu = new ArrayList<>();

    public int getID() {
        return ID;
    }

    public Date getDataWykonania() {
        return dataWykonania;
    }

    public Date getDataBilansu() {
        return dataBilansu;
    }

    public List<PozycjaBilansuTO> getPozycjeBilansu() {
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

    public void setPozycjeBilansu(List<PozycjaBilansuTO> pozycjeBilansu) {
        this.pozycjeBilansu = pozycjeBilansu;
    }
}
