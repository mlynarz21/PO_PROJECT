package com.StoreX.common.datatypes.bo;

import com.StoreX.common.datatypes.enumerations.StatusWydania;
import com.StoreX.persistence.entity.Zamowienie;

import java.util.Date;

public class ZamowienieDostawyBO extends ZamowienieBO{

    private StatusWydania status;

    public StatusWydania getStatus() {
        return status;
    }

    public void setStatus(StatusWydania status) {
        this.status = status;
    }
}
