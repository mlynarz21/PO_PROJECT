package com.StoreX.persistence.entity.PrzyjecieWydanieEntities;
import com.StoreX.persistence.entity.ZamowienieEntities.ZamowienieZakupu;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.Date;

/**
 * WydanieZamowienia Entity - klasa reprezentacji obiektów bazy
 */
@Entity
public class WydanieZamowienia {

    @Id
    @GeneratedValue
    private Long ID;
    private Date data;

    @OneToOne
    private ZamowienieZakupu zamowienie;

    public WydanieZamowienia(){}

    public WydanieZamowienia(Long ID, Date data, ZamowienieZakupu zamowienie){
        this.ID=ID;
        this.data=data;
        this.zamowienie=zamowienie;
    }

    public WydanieZamowienia( Date data, ZamowienieZakupu zamowienie){

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

    public ZamowienieZakupu getZamowienie() {
        return zamowienie;
    }

    public void setZamowienie(ZamowienieZakupu zamowienie) {
        this.zamowienie = zamowienie;
    }
}
