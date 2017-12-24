package com.crashcourse.restclient.datatype;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class PrzyjecieZamowieniaTO {
    private int ID;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
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
