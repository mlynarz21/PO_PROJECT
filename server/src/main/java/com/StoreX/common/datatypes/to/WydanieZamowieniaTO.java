package com.StoreX.common.datatypes.to;
import java.util.Date;

public class WydanieZamowieniaTO {
    private Long ID;
    private Date data;
    private ZamowienieZakupuTO zamowienie;

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

    public ZamowienieZakupuTO getZamowienie() {
        return zamowienie;
    }

    public void setZamowienie(ZamowienieZakupuTO zamowienie) {
        this.zamowienie = zamowienie;
    }
}
