package com.StoreX.persistence.entity;
import java.util.Date;

public class WydanieZamowienia {
    private int ID;
    private Date data;
    private ZamowienieZakupu zamowienie;

    public WydanieZamowienia(int ID, Date data, ZamowienieZakupu zamowienie){
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

    public ZamowienieZakupu getZamowienie() {
        return zamowienie;
    }

    public void setZamowienie(ZamowienieZakupu zamowienie) {
        this.zamowienie = zamowienie;
    }
}
