package com.StoreX.api;

import com.StoreX.common.datatypes.to.PozycjaZamowieniaTO;
import com.StoreX.common.datatypes.to.ZamowienieTO;
import com.StoreX.common.datatypes.to.ZamowienieZakupuTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * REST API Pozycji Zamówienia
 */
public interface PozycjaZamowieniaApi {

    /**
     * Pobiera wszystkie Pozycje Zamówienia dla Zamówienia o podanym Id
     * @param ID IdZamówienia
     * @param sessionId Id sesji
     * @return Lista pozycji zamówień
     */
    ResponseEntity<List<PozycjaZamowieniaTO>> getPozycjeZamowienia(Long ID, String sessionId);

    /**
     * Pobierea wskazaną ilośc towaru z lokalizacji i dodaje do ilości zrealizowanej w pozycji zamówienia.
     * Metoda wykorzystywana przy kompletowaniu zamówienia.
     * @param transferList Lista parametrów (Id Pozycji Bilansu, Id Umieszczenia, Ilość)
     * @param sessionId Id sesji
     * @return Informację o powodzeniu operacji
     */
    ResponseEntity<Boolean> proceedPozycjaZamowienia(List<Double> transferList, String sessionId);

}

