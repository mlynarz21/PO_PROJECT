package com.StoreX.api;

import com.StoreX.common.datatypes.to.ZamowienieTO;
import com.StoreX.common.datatypes.to.ZamowienieZakupuTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * REST API Zamówienia Zakupu
 */
public interface ZamowienieZakupuApi {

    /**
     * Pobiera wszystkie zamowienia zakupu o statusie Zaakceptowane
     * @param sessionId Id sesji
     * @return Lista zamowien zakupu o statusie Zaakceptowane
     */
    ResponseEntity<List<ZamowienieZakupuTO>> getAllZaakceptowane(String sessionId);

    /**
     * Zmienai status zamówienia zakupu o wskazanym Id na Gotowe
     * @param ID Id Zamowienia zakupu
     * @param sessionId Id sesji
     * @return Informacja o powodzeniu operacji
     */
    ResponseEntity<Boolean> updateStatusZamowienieZakupu(Long ID, String sessionId);

}
