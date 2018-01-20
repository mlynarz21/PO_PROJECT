package com.StoreX.service.BilansServices;

import com.StoreX.common.datatypes.bo.BilansBO;

import javax.naming.AuthenticationException;

public interface BilansSearchService {
    /**
     * Wyszukuje bilans z najpóźniejszą datą
     * @param sessionId Id sesji użytkownika wysyłąjącego zapytanie
     * @return Bilans z najnowszą datą bilansowania
     * @throws AuthenticationException
     */
    BilansBO findLast(String sessionId) throws AuthenticationException;
}
