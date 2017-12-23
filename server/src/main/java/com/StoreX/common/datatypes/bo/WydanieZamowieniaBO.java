package com.StoreX.common.datatypes.bo;
import com.StoreX.persistence.entity.ZamowienieZakupu;

import java.util.Date;

public class WydanieZamowieniaBO {
    private int ID;
    private Date data;
    private ZamowienieZakupuBO zamowienie;

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

    public ZamowienieZakupuBO getZamowienie() {
        return zamowienie;
    }

    public void setZamowienie(ZamowienieZakupuBO zamowienie) {
        this.zamowienie = zamowienie;
    }
}
