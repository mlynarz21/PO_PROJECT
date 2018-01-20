package com.StoreX.common.datatypes.bo;

/**
 * Obiekt biznesowy klasy Bilans - używany do operacji w warstwie logiki biznesowej
 */
public class JednostkaBO {
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
