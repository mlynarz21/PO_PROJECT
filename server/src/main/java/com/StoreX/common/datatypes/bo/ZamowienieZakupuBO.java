package com.StoreX.common.datatypes.bo;

import com.StoreX.common.datatypes.enumerations.StatusDostawy;
import com.StoreX.persistence.entity.Klient;
import com.StoreX.persistence.entity.Zamowienie;

import java.util.Date;

public class ZamowienieZakupuBO extends ZamowienieBO{

    private StatusDostawy status;
    private KlientBO klient;

    public StatusDostawy getStatus() {
        return status;
    }

    public void setStatus(StatusDostawy status) {
        this.status = status;
    }

    public KlientBO getKlient() {
        return klient;
    }

    public void setKlient(KlientBO klient) {
        this.klient = klient;
    }
}

