package com.crashcourse.restclient.datatype;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * klasa Bilans obiektu transferowego - używanego w komunikacji między serwerem a klientem
 */
public class BilansTO {

    private Long ID;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private Date dataWykonania;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private Date dataBilansu;

    /**
     * pobiera ID bilansu
     * @return ID bilansu
     */
    public Long getID() {
        return ID;
    }

    /**
     * pobiera datę wykonania bilansu
     * @return data wykonania bilansu
     */
    public Date getDataWykonania() {
        return dataWykonania;
    }

    /**
     * pobiera datę miesiąca bilansowanego
     * @return data miesiąca bilansowanego
     */
    public Date getDataBilansu() {
        return dataBilansu;
    }

    /**
     * ustawia ID bilansu
     * @param ID nowe ID
     */
    public void setID(Long ID) {
        this.ID = ID;
    }

    /**
     * ustawia dateę wykonania bilansu
     * @param dataWykonania nowa data wykonania
     */
    public void setDataWykonania(Date dataWykonania) {
        this.dataWykonania = dataWykonania;
    }

    /**
     * ustawia datę miesiąca bilansowanego
     * @param dataBilansu nowa data reprezentująca miesiąc bilansowany
     */
    public void setDataBilansu(Date dataBilansu) {
        this.dataBilansu = dataBilansu;
    }
}
