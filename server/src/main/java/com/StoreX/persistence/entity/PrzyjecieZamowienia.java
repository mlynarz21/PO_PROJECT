package com.StoreX.persistence.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class PrzyjecieZamowienia {

    @Id
    @GeneratedValue
    private Long ID;
    private Date data;

    @OneToOne
    private ZamowienieDostawy zamowienie;

    public PrzyjecieZamowienia(){}

    public PrzyjecieZamowienia(Long ID, Date data, ZamowienieDostawy zamowienie){
        this.ID=ID;
        this.data=data;
        this.zamowienie=zamowienie;
    }

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

    public ZamowienieDostawy getZamowienie() {
        return zamowienie;
    }

    public void setZamowienie(ZamowienieDostawy zamowienie) {
        this.zamowienie = zamowienie;
    }
}
