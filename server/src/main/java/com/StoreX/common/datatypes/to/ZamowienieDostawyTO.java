package com.StoreX.common.datatypes.to;

import com.StoreX.common.datatypes.enumerations.StatusWydania;

/**
 * klasa ZamowienieDostawy obiektu transferowego - używana w komunikacji między serwerem a klientem
 */
public class ZamowienieDostawyTO extends ZamowienieTO{

    private StatusWydania status;

    public StatusWydania getStatus() {
        return status;
    }

    public void setStatus(StatusWydania status) {
        this.status = status;
    }
}
