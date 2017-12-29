package com.StoreX.persistence.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.Date;

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
