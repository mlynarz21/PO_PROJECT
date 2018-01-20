package com.StoreX.service.UmieszczenieServices;

import com.StoreX.common.datatypes.bo.UmieszczenieBO;

import javax.naming.AuthenticationException;
import java.util.List;

public interface UmieszczenieSearchService {
    /**
     * Wyszukuje wszystkie umieszczenia dla towaru o podanym Id
     * @param sessionId Id sesji użytkownika wysyłąjącego zapytanie
     * @param ID Id Towaru, którego dotyczy zapytanie
     * @return Lista umieszczeń towaru
     * @throws AuthenticationException
     */
    List<UmieszczenieBO> findAllForTowar(String sessionId, Long ID) throws AuthenticationException;
}
