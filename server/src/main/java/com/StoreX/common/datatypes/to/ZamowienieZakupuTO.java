package com.StoreX.common.datatypes.to;

import com.StoreX.common.datatypes.enumerations.StatusDostawy;
import com.StoreX.persistence.entity.Klient;
import com.StoreX.persistence.entity.Zamowienie;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class ZamowienieZakupuTO extends ZamowienieTO{

    private StatusDostawy status;
    private KlientTO klient;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
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

