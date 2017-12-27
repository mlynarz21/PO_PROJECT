package com.StoreX.persistence.entity;

import com.StoreX.common.datatypes.enumerations.StatusDostawy;
import com.StoreX.common.datatypes.enumerations.StatusWydania;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;

@Entity
public class ZamowienieDostawy extends Zamowienie{

    @Enumerated(EnumType.STRING)
    private StatusDostawy status;

    public ZamowienieDostawy(Long ID, String kod, Date dataZlozenia, StatusDostawy status){
        super(ID,kod,dataZlozenia);
        this.status=status;
    }

    public StatusDostawy getStatus() {
        return status;
    }

    public void setStatus(StatusDostawy status) {
        this.status = status;
    }
}
