package com.crashcourse.restclient.api;

import com.crashcourse.restclient.datatype.PozycjaZamowieniaTO;
import com.crashcourse.restclient.datatype.ZamowienieTO;

import java.util.List;

/**
 * REST client odpiwiadający za pozycję zamówienia REST service.
 */
public interface PozycjaZamowieniaRestServiceClient {

    /**
     * metoda odpowiadająca za zmianę ilościową stanu pozycji i umieszczenia w bazie
     * @param idPozycji id pozycji inkrementowanej
     * @param idUmieszcznia id umieszczenia dekrementowanej
     * @param ilosc ilośc która jest procesowana
     */
    void proceedPozycjaZamowienia(Long idPozycji, Long idUmieszcznia, double ilosc);

    /**
     * metoda pobierająca wszystie pozycje zamowienia o podanym ID
     * @param ID id zamówienia ktrórego dotyczą pozycje
     * @return lista zawierająca pozycje danego zamówienia
     */
    List<PozycjaZamowieniaTO> getPozycjeZamowienia(Long ID);


}
