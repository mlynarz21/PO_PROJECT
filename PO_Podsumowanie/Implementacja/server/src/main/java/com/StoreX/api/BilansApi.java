package com.StoreX.api;

import com.StoreX.common.datatypes.to.BilansTO;
import org.springframework.http.ResponseEntity;

import java.util.Date;

/**
 * REST API Bilansu
 */
public interface BilansApi {

    /**
     * Pobiera bilans z najpóźniejszą datą bilansowaną
     * @param sessionId Id sesji użytkownika wysyłąjącego żądanie
     * @return Bilans z najpóźniejszą datą bilansowaną
     */
    ResponseEntity<BilansTO> getLastBilans(String sessionId);

    /**
     * Dodaje bilans z aktualną datą jako data wykonania bilansu oraz datą bilansowaną przekazaną w parametrze
     * @param dataBilansowana bilansowana data
     * @param sessionId Id sesji użytkownika wysyłąjącego żądanie
     * @return Informacja o powodzeniu operacji dodawania bilansu
     */
    ResponseEntity<Boolean> addBilans(Date dataBilansowana, String sessionId);
}
