package com.StoreX.persistence.entity;

import com.StoreX.common.datatypes.enumerations.StatusWydania;
import com.StoreX.common.datatypes.enumerations.TypOdbioru;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;
import java.util.Date;

@Entity
public class ZamowienieZakupu extends Zamowienie{

    @Enumerated(EnumType.STRING)
    private StatusWydania status;
    @OneToOne
    private Klient klient;
    private Date terminRealizacji;
    @Enumerated(EnumType.STRING)
    private TypOdbioru typOdbioru;



    public ZamowienieZakupu(){}

    public ZamowienieZakupu(Long ID, String kod, Date dataZlozenia, StatusWydania status, Klient klient, TypOdbioru typOdbioru){
        super(ID,kod,dataZlozenia);
        this.status=status;
        this.klient=klient;
        this.typOdbioru = typOdbioru;
    }

    public StatusWydania getStatus() {
        return status;
    }

    public void setStatus(StatusWydania status) {
        this.status = status;
    }

    public Klient getKlient() {
        return klient;
    }

    public void setKlient(Klient klient) {
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

