package com.StoreX.common.datatypes.to;

import com.StoreX.common.datatypes.enumerations.StatusDostawy;
import com.StoreX.persistence.entity.Klient;
import com.StoreX.persistence.entity.Zamowienie;

public class ZamowienieZakupuTO extends ZamowienieTO{

    private StatusDostawy status;
    private KlientTO klient;

    public StatusDostawy getStatus() {
        return status;
    }

    public void setStatus(StatusDostawy status) {
        this.status = status;
    }

    public KlientTO getKlient() {
        return klient;
    }

    public void setKlient(KlientTO klient) {
        this.klient = klient;
    }
}

