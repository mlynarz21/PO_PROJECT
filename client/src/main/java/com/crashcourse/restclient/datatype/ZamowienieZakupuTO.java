package com.crashcourse.restclient.datatype;


import com.crashcourse.restclient.datatype.enumeration.StatusDostawy;
import com.crashcourse.restclient.datatype.enumeration.TypOdbioru;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * klasa ZamowienieZakupu obiektu transferowego - używana w komunikacji między serwerem a klientem
 */
public class ZamowienieZakupuTO extends ZamowienieTO{

    private StatusDostawy status;
    private KlientTO klient;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
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

