package com.crashcourse.restclient.api;

import com.crashcourse.restclient.datatype.PozycjaZamowieniaTO;
import com.crashcourse.restclient.datatype.ZamowienieTO;

import java.util.List;

public interface PozycjaZamowieniaRestServiceClient {

    void updatePozycjaZamowienia(PozycjaZamowieniaTO pozycjaZamowienia);

    List<PozycjaZamowieniaTO> getPozycjeZamowienia(ZamowienieTO zamowienie);


}
