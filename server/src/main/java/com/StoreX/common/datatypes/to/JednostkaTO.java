package com.StoreX.common.datatypes.to;

/**
 * klasa Jednostka obiektu transferowego - używana w komunikacji między serwerem a klientem
 */
public class JednostkaTO {
    private Long ID;
    private String rodzaj;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getRodzaj() {
        return rodzaj;
    }

    public void setRodzaj(String rodzaj) {
        this.rodzaj = rodzaj;
    }
}
