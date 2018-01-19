package com.StoreX.service.ZamowienieServices;

import javax.naming.AuthenticationException;

public interface ZamowienieZakupuUpdateService {
    /**
     * Zmienia status zamówienia zakupu o wskazanym Id na Gotowe
     * @param sessionId Id sesji
     * @param ID Id zamówienia zakupu
     * @throws AuthenticationException
     */
    void updateStatusZamowienia(String sessionId, Long ID) throws AuthenticationException;
}
