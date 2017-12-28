package com.StoreX.common.datatypes.bo;
import java.util.Date;

public class WydanieZamowieniaBO {
    private Long ID;
    private Date data;
    private ZamowienieZakupuBO zamowienie;

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

    public ZamowienieZakupuBO getZamowienie() {
        return zamowienie;
    }

    public void setZamowienie(ZamowienieZakupuBO zamowienie) {
        this.zamowienie = zamowienie;
    }
}
