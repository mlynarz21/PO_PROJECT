package com.StoreX.common.datatypes.bo;

import com.StoreX.common.datatypes.enumerations.StatusDostawy;
import com.StoreX.common.datatypes.enumerations.StatusWydania;
import com.StoreX.persistence.entity.Klient;
import com.StoreX.persistence.entity.Zamowienie;

import java.util.Date;

public class ZamowienieZakupuBO extends ZamowienieBO{

    private StatusWydania status;
    private KlientBO klient;

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
}

