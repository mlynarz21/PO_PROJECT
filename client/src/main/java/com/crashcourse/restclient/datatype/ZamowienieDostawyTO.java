package com.crashcourse.restclient.datatype;

import com.crashcourse.restclient.datatype.enumeration.StatusWydania;

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