package com.crashcourse.restclient.datatype;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class WydanieZamowieniaTO {
    private int ID;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date data;
    private ZamowienieZakupuTO zamowienie;

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

    public ZamowienieZakupuTO getZamowienie() {
        return zamowienie;
    }

    public void setZamowienie(ZamowienieZakupuTO zamowienie) {
        this.zamowienie = zamowienie;
    }
}
