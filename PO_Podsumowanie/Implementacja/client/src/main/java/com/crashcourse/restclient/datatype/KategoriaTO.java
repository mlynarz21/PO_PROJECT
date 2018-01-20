package com.crashcourse.restclient.datatype;

/**
 * klasa Kategoria obiektu transferowego - używana w komunikacji między serwerem a klientem
 */
public class KategoriaTO {
    private Long ID;
    private String kategoria;

    /**
     * pobiera ID kategorii
     * @return ID kategorii
     */
    public Long getID() {
        return ID;
    }

    /**
     * ustawia ID kategorii
     * @param ID nowe ID
     */
    public void setID(Long ID) {
        this.ID = ID;
    }

    /**
     * pobiera kategorię
     * @return kategoria
     */
    public String getKategoria() {
        return kategoria;
    }

    /**
     * ustawia kateogorię
     * @param kategoria nowa kategoria
     */
    public void setKategoria(String kategoria) {
        this.kategoria = kategoria;
    }
}
