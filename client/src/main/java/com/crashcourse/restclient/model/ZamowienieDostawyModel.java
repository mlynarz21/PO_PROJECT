package com.crashcourse.restclient.model;

import com.crashcourse.restclient.datatype.ZamowienieTO;
import com.crashcourse.restclient.datatype.enumeration.StatusWydania;
import javafx.beans.property.SimpleObjectProperty;

public class ZamowienieDostawyModel extends ZamowienieTO{

    private SimpleObjectProperty<StatusWydania> status;

    public SimpleObjectProperty<StatusWydania> getStatus() {
        return status;
    }

    public void setStatus(SimpleObjectProperty<StatusWydania> status) {
        this.status = status;
    }
}
