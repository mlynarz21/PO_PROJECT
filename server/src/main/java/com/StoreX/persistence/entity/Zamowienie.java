package com.StoreX.persistence.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@DiscriminatorColumn
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Zamowienie {

    @Id
    @GeneratedValue
    private Long ID;
    private String kod;
    private Date dataZlozenia;

    public Zamowienie(){}
    public Zamowienie(Long ID, String kod, Date dataZlozenia){
        this.ID=ID;
        this.kod=kod;
        this.dataZlozenia=dataZlozenia;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
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
}
