package com.StoreX.common.datatypes.to;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * klasa PrzyjecieZamowienia obiektu transferowego - używana w komunikacji między serwerem a klientem
 */
public class PrzyjecieZamowieniaTO {
    private Long ID;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private Date data;
    private ZamowienieDostawyTO zamowienie;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public ZamowienieDostawyTO getZamowienie() {
        return zamowienie;
    }

    public void setZamowienie(ZamowienieDostawyTO zamowienie) {
        this.zamowienie = zamowienie;
    }
}
