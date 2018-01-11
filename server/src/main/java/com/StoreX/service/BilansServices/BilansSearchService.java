package com.StoreX.service.BilansServices;

import com.StoreX.common.datatypes.bo.BilansBO;

import javax.naming.AuthenticationException;

public interface BilansSearchService {
    /**
     * Wyszukuje bilans z najpóźniejszą datą
     * @param sessionId Id sesji
     * @return Bilans z najpóźniejsza datą
     * @throws AuthenticationException
     */
    public BilansBO findLast(String sessionId) throws AuthenticationException;
}
