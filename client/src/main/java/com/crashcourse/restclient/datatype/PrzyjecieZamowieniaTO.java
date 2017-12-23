package com.crashcourse.restclient.datatype;

import java.util.Date;

public class PrzyjecieZamowieniaTO {
    private int ID;
    private Date data;
    private ZamowienieDostawyTO zamowienie;

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

    public ZamowienieDostawyTO getZamowienie() {
        return zamowienie;
    }

    public void setZamowienie(ZamowienieDostawyTO zamowienie) {
        this.zamowienie = zamowienie;
    }
}
