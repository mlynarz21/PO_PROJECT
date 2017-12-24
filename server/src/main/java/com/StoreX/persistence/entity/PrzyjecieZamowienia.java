package com.StoreX.persistence.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class PrzyjecieZamowienia {

    @Id
    @GeneratedValue
    private int ID;
    private Date data;

    @OneToOne
    private ZamowienieDostawy zamowienie;

    @OneToMany(mappedBy = "przyjecieZamowienia")
    private List<PozycjaPrzyjecia> pozycjePrzyjecia = new ArrayList<>();

    public PrzyjecieZamowienia(int ID, Date data, ZamowienieDostawy zamowienie){
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

    public ZamowienieDostawy getZamowienie() {
        return zamowienie;
    }

    public void setZamowienie(ZamowienieDostawy zamowienie) {
        this.zamowienie = zamowienie;
    }
}
