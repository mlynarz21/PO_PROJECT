package com.crashcourse.restclient.datatype;

/**
 * klasa Lokalizacja obiektu transferowego - używana w komunikacji między serwerem a klientem
 */
public class LokalizacjaTO {
    private Long ID;
    private String kod;
    private int numerRzedu;
    private int numerRegalu;
    private int numerSektora;

    /**
     * pobiera ID lokalizacji
     * @return ID lokalizacji
     */
    public Long getID() {
        return ID;
    }

    /**
     * ustawia ID lokalizacji
     * @param ID nowe ID
     */
    public void setID(Long ID) {
        this.ID = ID;
    }

    /**
     * pobiera kod lokalizacji
     * @return kod lokalizacji
     */
    public String getKod() {
        return kod;
    }

    /**
     * ustawia kod dla lokalizacji
     * @param kod nowy kod lokalizacji
     */
    public void setKod(String kod) {
        this.kod = kod;
    }

    /**
     * pobiera numer rzędu lokalizacji
     * @return numer rzędu
     */
    public int getNumerRzedu() {
        return numerRzedu;
    }

    /**
     * ustawia numer rzędu lokalizacji
     * @param numerRzedu nowy numer rzędu
     */
    public void setNumerRzedu(int numerRzedu) {
        this.numerRzedu = numerRzedu;
    }

    /**
     * pobiera numer regału
     * @return numer regału lokalizacji
     */
    public int getNumerRegalu() {
        return numerRegalu;
    }

    /**
     * ustawia numer regału
     * @param numerRegalu nowy numer regału
     */
    public void setNumerRegalu(int numerRegalu) {
        this.numerRegalu = numerRegalu;
    }

    /**
     * pobiera numer sektora
     * @return numer sektora lokalizacji
     */
    public int getNumerSektora() {
        return numerSektora;
    }

    /**
     * ustawia numer sektora lokalizacji
     * @param numerSektora nowy numer sektora
     */
    public void setNumerSektora(int numerSektora) {
        this.numerSektora = numerSektora;
    }
}


