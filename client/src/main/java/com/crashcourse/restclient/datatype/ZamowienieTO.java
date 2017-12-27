package com.crashcourse.restclient.datatype;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

public abstract class ZamowienieTO {
    private Long ID;
    private String kod;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dataZlozenia;
    private List<PozycjaZamowieniaTO> pozycjeZamowienia;

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

    public List<PozycjaZamowieniaTO> getPozycjeZamowienia() {
        return pozycjeZamowienia;
    }

    public void setPozycjeZamowienia(List<PozycjaZamowieniaTO> pozycjeZamowienia) {
        this.pozycjeZamowienia = pozycjeZamowienia;
    }
}
