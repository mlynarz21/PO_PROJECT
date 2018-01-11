package com.StoreX.service.ZamowienieServices;

import com.StoreX.common.datatypes.bo.ZamowienieZakupuBO;

import javax.naming.AuthenticationException;
import java.util.List;

public interface ZamowienieZakupuSearchService {
    /**
     * Wyszukuje wszystkie zamówienia zakupu o statusie zaakceptowane
     * @param sessionId Id sesji
     * @return Lista zamówień zakupu o statusie zaakceptowane
     * @throws AuthenticationException
     */
    public List<ZamowienieZakupuBO> findAllAccepted(String sessionId) throws AuthenticationException;
}
