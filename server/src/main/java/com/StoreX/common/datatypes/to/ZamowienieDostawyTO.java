package com.StoreX.common.datatypes.to;

import com.StoreX.common.datatypes.enumerations.StatusWydania;
import com.StoreX.persistence.entity.Zamowienie;

public class ZamowienieDostawyTO extends ZamowienieTO{

    private StatusWydania status;

    public StatusWydania getStatus() {
        return status;
    }

    public void setStatus(StatusWydania status) {
        this.status = status;
    }
}
