package com.StoreX.persistence.entity;

import com.StoreX.common.datatypes.enumerations.StatusWydania;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;

@Entity
public class ZamowienieDostawy extends Zamowienie{

    @Enumerated(EnumType.STRING)
    private StatusWydania status;


    public ZamowienieDostawy(int ID, String kod, Date dataZlozenia, StatusWydania status){
        super(ID,kod,dataZlozenia);
        this.status=status;
    }

    public StatusWydania getStatus() {
        return status;
    }

    public void setStatus(StatusWydania status) {
        this.status = status;
    }
}
