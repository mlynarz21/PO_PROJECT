package com.StoreX.common.datatypes.bo;

import com.StoreX.common.datatypes.enumerations.StatusDostawy;
import com.StoreX.common.datatypes.enumerations.StatusWydania;
import com.StoreX.common.datatypes.enumerations.TypOdbioru;
import com.StoreX.persistence.entity.Klient;
import com.StoreX.persistence.entity.Zamowienie;

import java.util.Date;

public class ZamowienieZakupuBO extends ZamowienieBO{

    private StatusWydania status;
    private KlientBO klient;
    private Date terminRealizacji;
    private TypOdbioru typOdbioru;

    public StatusWydania getStatus() {
        return status;
    }

    public void setStatus(StatusWydania status) {
        this.status = status;
    }

    public KlientBO getKlient() {
        return klient;
    }

    public void setKlient(KlientBO klient) {
        this.klient = klient;
    }

    public Date getTerminRealizacji() {
        return terminRealizacji;
    }

    public void setTerminRealizacji(Date terminRealizacji) {
        this.terminRealizacji = terminRealizacji;
    }

    public TypOdbioru getTypOdbioru() {
        return typOdbioru;
    }

    public void setTypOdbioru(TypOdbioru typOdbioru) {
        this.typOdbioru = typOdbioru;
    }
}



