package com.StoreX.persistence.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public abstract class Zamowienie {

    @Id
    @GeneratedValue
    private int ID;
    private String kod;
    private Date dataZlozenia;

    @OneToMany(mappedBy = "zamowienie")
    private List<PozycjaZamowienia> pozycjeZamowienia;

    public Zamowienie(int ID, String kod, Date dataZlozenia){
        pozycjeZamowienia= new ArrayList<>();
        this.ID=ID;
        this.kod=kod;
        this.dataZlozenia=dataZlozenia;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getKod() {
        return kod;
    }

    public void setKod(String kod) {
        this.kod = kod;
    }

    public Date getDataZlozenia() {
        return dataZlozenia;
    }

    public void setDataZlozenia(Date dataZlozenia) {
        this.dataZlozenia = dataZlozenia;
    }

    public List<PozycjaZamowienia> getPozycjeZamowienia() {
        return pozycjeZamowienia;
    }

    public void setPozycjeZamowienia(List<PozycjaZamowienia> pozycjeZamowienia) {
        this.pozycjeZamowienia = pozycjeZamowienia;
    }
}
