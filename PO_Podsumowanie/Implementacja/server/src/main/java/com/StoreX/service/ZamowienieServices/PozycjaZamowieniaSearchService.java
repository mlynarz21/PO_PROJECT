package com.StoreX.service.ZamowienieServices;

import com.StoreX.common.datatypes.bo.PozycjaZamowieniaBO;

import javax.naming.AuthenticationException;
import java.util.List;

public interface PozycjaZamowieniaSearchService {
    /**
     * Wyszukuje wszyskie pozycje zamówienia dla zamówienia o podanym Id
     * @param sessionId Id sesji użytkownika wysyłąjącego zapytanie
     * @param ID Id Zamówienia, którego dotyczy zapytanie
     * @return Lista pozycji zamówienia o podanym ID
     * @throws AuthenticationException
     */
    List<PozycjaZamowieniaBO> findAllforZamowienie(String sessionId, Long ID) throws AuthenticationException;
}
