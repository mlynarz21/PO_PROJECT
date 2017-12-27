package com.crashcourse.restclient.api;

import com.crashcourse.restclient.datatype.ZamowienieTO;
import com.crashcourse.restclient.datatype.ZamowienieZakupuTO;

import java.util.List;

public interface ZamowienieZakupuRestServiceClient {

    List<ZamowienieZakupuTO> getAllZaakceptowane();

    void updateStatusZamowienieZakupu(ZamowienieZakupuTO zamowienie);
}
