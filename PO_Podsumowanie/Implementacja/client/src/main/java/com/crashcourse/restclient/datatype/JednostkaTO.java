package com.crashcourse.restclient.datatype;

/**
 * klasa Jednostka obiektu transferowego - używana w komunikacji między serwerem a klientem
 */
public class JednostkaTO {
    private Long ID;
    private String rodzaj;

    /**
     * pobiera ID jednostki
     * @return ID jednostki
     */
    public Long getID() {
        return ID;
    }

    /**
     * ustawia ID jednostki
     * @param ID nowe ID
     */
    public void setID(Long ID) {
        this.ID = ID;
    }

    /**
     * pobiera rodzaj jednostki
     * @return rodzaj jednotki
     */
    public String getRodzaj() {
        return rodzaj;
    }

    /**
     * ustawia rodzaj jednostki
     * @param rodzaj nowy rodzaj do ustawienia
     */
    public void setRodzaj(String rodzaj) {
        this.rodzaj = rodzaj;
    }
}

