package com.StoreX.common.datatypes.bo;

import com.StoreX.common.datatypes.enumerations.StatusDostawy;
import com.StoreX.common.datatypes.enumerations.StatusWydania;
import com.StoreX.persistence.entity.Zamowienie;

import javax.xml.transform.sax.SAXTransformerFactory;
import java.util.Date;

public class ZamowienieDostawyBO extends ZamowienieBO{

    private StatusDostawy status;

    public StatusDostawy getStatus() {
        return status;
    }

    public void setStatus(StatusDostawy status) {
        this.status = status;
    }
}
