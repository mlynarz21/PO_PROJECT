package com.StoreX.persistence.entity;

import com.StoreX.common.datatypes.enumerations.StatusDostawy;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;
import java.util.Date;

@Entity
public class ZamowienieZakupu extends Zamowienie{

    @Enumerated(EnumType.STRING)
    private StatusDostawy status;

    @OneToOne
    private Klient klient;

    public ZamowienieZakupu(Long ID, String kod, Date dataZlozenia, StatusDostawy status, Klient klient){
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

