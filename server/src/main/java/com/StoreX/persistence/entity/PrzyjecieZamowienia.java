package com.StoreX.persistence.entity;

import java.util.Date;

public class PrzyjecieZamowienia {
    private int ID;
    private Date data;
    private ZamowienieDostawy zamowienie;

    public PrzyjecieZamowienia(int ID, Date data, ZamowienieDostawy zamowienie){
        this.ID=ID;
        this.data=data;
        this.zamowienie=zamowienie;
    }

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

    public ZamowienieDostawy getZamowienie() {
        return zamowienie;
    }

    public void setZamowienie(ZamowienieDostawy zamowienie) {
        this.zamowienie = zamowienie;
    }
}
