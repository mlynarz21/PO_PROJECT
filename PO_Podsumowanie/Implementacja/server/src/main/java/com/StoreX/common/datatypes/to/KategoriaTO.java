package com.StoreX.common.datatypes.to;

/**
 * klasa Kategoria obiektu transferowego - używana w komunikacji między serwerem a klientem
 */
public class KategoriaTO {
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
