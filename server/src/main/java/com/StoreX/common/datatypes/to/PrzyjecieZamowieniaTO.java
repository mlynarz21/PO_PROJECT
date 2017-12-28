package com.StoreX.common.datatypes.to;

import com.StoreX.persistence.entity.ZamowienieDostawy;

import java.util.Date;

public class PrzyjecieZamowieniaTO {
    private Long ID;
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
