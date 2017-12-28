package com.StoreX.common.datatypes.to;

import com.StoreX.common.datatypes.enumerations.StatusDostawy;
import com.StoreX.common.datatypes.enumerations.TypOdbioru;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

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

