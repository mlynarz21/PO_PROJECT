package com.StoreX.api;

import com.StoreX.common.datatypes.to.UmieszczenieTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * REST API Umieszczenia
 */
public interface UmieszczenieApi {

    /**
     * Pobiera wszystkie umieszczenia wskazanego towaru
     * @param id Id Towaru
     * @param sessionId Id sesji użytkownika wysyłąjącego żądanie
     * @return Lista umieszczeń wskazanego towaru
     */
    ResponseEntity<List<UmieszczenieTO>> getUmieszczenieTowaru(Long id, String sessionId);

}
