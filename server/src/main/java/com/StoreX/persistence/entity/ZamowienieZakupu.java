package com.StoreX.persistence.entity;

import com.StoreX.common.datatypes.enumerations.StatusDostawy;

import java.util.Date;

public class ZamowienieZakupu extends Zamowienie{

    private StatusDostawy status;
    private Klient klient;

    public ZamowienieZakupu(int ID, String kod, Date dataZlozenia, StatusDostawy status, Klient klient){
        super(ID,kod,dataZlozenia);
        this.status=status;
        this.klient=klient;
    }

    public StatusDostawy getStatus() {
        return status;
    }

    public void setStatus(StatusDostawy status) {
        this.status = status;
    }

    public Klient getKlient() {
        return klient;
    }

    public void setKlient(Klient klient) {
        this.klient = klient;
    }
}

