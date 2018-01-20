package com.StoreX.persistence.entity.TowarEntities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

/**
 * Jednostka Entity - klasa reprezentacji obiektów bazy
 */
@Entity
public class Jednostka {

    @Id
    @GeneratedValue
    private Long ID;

    @Size(max = 32)
    private String rodzaj;


    public Jednostka(){}
    public Jednostka(Long ID, String rodzaj){
        this.ID=ID;
        this.rodzaj=rodzaj;
    }

    public Jednostka( String rodzaj){

        this.rodzaj=rodzaj;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getRodzaj() {
        return rodzaj;
    }

    public void setRodzaj(String rodzaj) {
        this.rodzaj = rodzaj;
    }
}
