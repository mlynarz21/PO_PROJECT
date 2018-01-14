package com.StoreX.api;

import com.StoreX.common.datatypes.to.BilansTO;
import com.StoreX.common.datatypes.to.PozycjaZamowieniaTO;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.List;

/**
 * REST API Bilansu
 */
public interface BilansApi {

    /**
     * Pobiera bilans z najpóźniejszą datą bilansowaną
     * @param sessionId sessionId
     * @return Bilans z najpóźniejszą datą bilansowaną
     */
    ResponseEntity<BilansTO> getLastBilans(String sessionId);

    /**
     * Dodaje bilans z aktualną datą jako data wykonania bilansu oraz datą bilansowaną przekazaną w parametrze
     * @param dataBilansowana bilansowana data
     * @param sessionId sessionId
     * @return Informacja o powodzeniu operacji dodawania bilansu
     */
    ResponseEntity<Boolean> addBilans(Date dataBilansowana, String sessionId);
}
