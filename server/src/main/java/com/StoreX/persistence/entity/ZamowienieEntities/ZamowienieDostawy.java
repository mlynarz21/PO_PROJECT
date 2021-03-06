package com.StoreX.persistence.entity.ZamowienieEntities;

import com.StoreX.common.datatypes.enumerations.StatusDostawy;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;

/**
 * ZamowienieDostawy Entity - klasa reprezentacji obiektów bazy
 */
@Entity
@DiscriminatorValue("ZamowienieDostawy")
public class ZamowienieDostawy extends Zamowienie{

    @Enumerated(EnumType.STRING)
    private StatusDostawy status;

    public ZamowienieDostawy(){}
    public ZamowienieDostawy(Long ID, String kod, Date dataZlozenia, StatusDostawy status){
        super(ID,kod,dataZlozenia);
        this.status=status;
    }

    public ZamowienieDostawy(String kod, Date dataZlozenia, StatusDostawy status){
        super(kod,dataZlozenia);
        this.status=status;
    }

    public StatusDostawy getStatus() {
        return status;
    }

    public void setStatus(StatusDostawy status) {
        this.status = status;
    }
}
