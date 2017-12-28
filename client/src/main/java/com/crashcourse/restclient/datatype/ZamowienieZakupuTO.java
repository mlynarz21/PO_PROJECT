package com.crashcourse.restclient.datatype;


import com.crashcourse.restclient.datatype.enumeration.StatusDostawy;
import com.crashcourse.restclient.datatype.enumeration.TypOdbioru;

import java.util.Date;

public class ZamowienieZakupuTO extends ZamowienieTO{

    private StatusDostawy status;
    private KlientTO klient;
    private Date terminRealizacji;
    private TypOdbioru typOdbioru;

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

    public TypOdbioru getTypOdbioru() {
        return typOdbioru;
    }

    public void setTypOdbioru(TypOdbioru typOdbioru) {
        this.typOdbioru = typOdbioru;
    }
}

