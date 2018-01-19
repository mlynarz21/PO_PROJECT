package com.StoreX.api;

import com.StoreX.common.datatypes.to.ZamowienieZakupuTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * REST API Zamówienia Zakupu
 */
public interface ZamowienieZakupuApi {

    /**
     * Pobiera wszystkie zamowienia zakupu o statusie Zaakceptowane
     * @param sessionId Id sesji użytkownika wysyłąjącego żądanie
     * @return Lista zamowien zakupu o statusie Zaakceptowane
     */
    ResponseEntity<List<ZamowienieZakupuTO>> getAllZaakceptowane(String sessionId);

    /**
     * Zmienia status zamówienia zakupu o wskazanym Id na Gotowe
     * @param ID Id Zamowienia zakupu
     * @param sessionId Id sesji użytkownika wysyłąjącego żądanie
     * @return Informacja o powodzeniu operacji
     */
    ResponseEntity<Boolean> updateStatusZamowienieZakupu(Long ID, String sessionId);

}
