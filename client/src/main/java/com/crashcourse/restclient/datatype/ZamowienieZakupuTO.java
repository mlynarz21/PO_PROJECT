package com.crashcourse.restclient.datatype;


import com.crashcourse.restclient.datatype.enumeration.StatusDostawy;

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

