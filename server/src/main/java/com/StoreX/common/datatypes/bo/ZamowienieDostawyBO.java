package com.StoreX.common.datatypes.bo;

import com.StoreX.common.datatypes.enumerations.StatusDostawy;

/**
 * Obiekt biznesowy klasy ZamowienieDostawy - używany do operacji w warstwie logiki biznesowej
 */
public class ZamowienieDostawyBO extends ZamowienieBO{

    private StatusDostawy status;

    public StatusDostawy getStatus() {
        return status;
    }

    public void setStatus(StatusDostawy status) {
        this.status = status;
    }
}
