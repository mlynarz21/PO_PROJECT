package com.crashcourse.restclient.api;

import com.crashcourse.restclient.datatype.PozycjaZamowieniaTO;
import com.crashcourse.restclient.datatype.ZamowienieTO;

import java.util.List;

public interface PozycjaZamowieniaRestServiceClient {

    void proceedPozycjaZamowienia(Long idPozycji, Long idUmieszcznia, double ilosc);

    List<PozycjaZamowieniaTO> getPozycjeZamowienia(Long ID);


}
