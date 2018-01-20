package com.StoreX.common.datatypes.bo;

/**
 * Obiekt biznesowy klasy Bilans - używany do operacji w warstwie logiki biznesowej
 */
public class KategoriaBO {
    private Long ID;
    private String kategoria;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getKategoria() {
        return kategoria;
    }

    public void setKategoria(String kategoria) {
        this.kategoria = kategoria;
    }
}
