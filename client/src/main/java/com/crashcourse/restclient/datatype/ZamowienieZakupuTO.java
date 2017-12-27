package com.crashcourse.restclient.datatype;


import com.crashcourse.restclient.datatype.enumeration.StatusDostawy;

import java.util.Date;

public class ZamowienieZakupuTO extends ZamowienieTO{

    private StatusDostawy status;
    private KlientTO klient;
    private Date terminRealizacji;

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

    public Date getTerminRealizacji() {
        return terminRealizacji;
    }

    public void setTerminRealizacji(Date terminRealizacji) {
        this.terminRealizacji = terminRealizacji;
    }
}

