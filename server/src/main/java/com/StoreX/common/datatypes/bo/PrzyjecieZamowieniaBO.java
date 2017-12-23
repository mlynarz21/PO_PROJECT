package com.StoreX.common.datatypes.bo;

import com.StoreX.persistence.entity.ZamowienieDostawy;

import java.util.Date;

public class PrzyjecieZamowieniaBO {
    private int ID;
    private Date data;
    private ZamowienieDostawyBO zamowienie;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public ZamowienieDostawyBO getZamowienie() {
        return zamowienie;
    }

    public void setZamowienie(ZamowienieDostawyBO zamowienie) {
        this.zamowienie = zamowienie;
    }
}
