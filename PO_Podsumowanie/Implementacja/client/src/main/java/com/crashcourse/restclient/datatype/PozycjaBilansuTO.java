package com.crashcourse.restclient.datatype;

/**
 * klasa PozycjaBilansu obiektu transferowego - używana w komunikacji między serwerem a klientem
 */
public class PozycjaBilansuTO {
    private Long ID;
    private double ilosc;
    private TowarTO towar;
    private BilansTO bilans;

    /**
     * pobiera ID pozycjiBilansu
     * @return ID pozycjiBilansu
     */
    public Long getID() {
        return ID;
    }

    /**
     * ustawia ID pozycjiBilansu
     * @param ID nowe ID
     */
    public void setID(Long ID) {
        this.ID = ID;
    }

    /**
     * pobiera aktualną ilość towaru w pozycji
     * @return ilość towaru
     */
    public double getIlosc() {
        return ilosc;
    }

    /**
     * ustawia ilość towaru w pozycji
     * @param ilosc nowa ilość towaru
     */
    public void setIlosc(double ilosc) {
        this.ilosc = ilosc;
    }

    /**
     * pobiera towar odnoszący się do pozycji
     * @return towar
     */
    public TowarTO getTowar() {
        return towar;
    }

    /**
     * ustawia towar dla pozycji bilansu
     * @param towar nowy towar
     */
    public void setTowar(TowarTO towar) {
        this.towar = towar;
    }

    /**
     * pobiera bilans związany z pozycją
     * @return bilans
     */
    public BilansTO getBilans() {
        return bilans;
    }

    /**
     * ustawia bilans dla pozycji
     * @param bilans nowy bilans
     */
    public void setBilans(BilansTO bilans) {
        this.bilans = bilans;
    }
}