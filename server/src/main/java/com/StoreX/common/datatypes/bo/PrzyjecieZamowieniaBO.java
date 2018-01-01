package com.StoreX.common.datatypes.bo;

import java.util.Date;

public class PrzyjecieZamowieniaBO {
    private Long ID;
    private Date data;
    private ZamowienieDostawyBO zamowienie;

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

    public ZamowienieDostawyBO getZamowienie() {
        return zamowienie;
    }

    public void setZamowienie(ZamowienieDostawyBO zamowienie) {
        this.zamowienie = zamowienie;
    }
}
