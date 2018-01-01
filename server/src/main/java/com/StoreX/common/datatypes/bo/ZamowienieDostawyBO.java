package com.StoreX.common.datatypes.bo;

import com.StoreX.common.datatypes.enumerations.StatusDostawy;

public class ZamowienieDostawyBO extends ZamowienieBO{

    private StatusDostawy status;

    public StatusDostawy getStatus() {
        return status;
    }

    public void setStatus(StatusDostawy status) {
        this.status = status;
    }
}
