package com.StoreX.common.datatypes.to;
import com.StoreX.persistence.entity.ZamowienieZakupu;

import java.util.Date;

public class WydanieZamowieniaTO {
    private int ID;
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
