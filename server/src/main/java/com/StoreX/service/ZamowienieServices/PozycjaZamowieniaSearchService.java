package com.StoreX.service.ZamowienieServices;

import com.StoreX.common.datatypes.bo.PozycjaZamowieniaBO;

import javax.naming.AuthenticationException;
import java.util.List;

public interface PozycjaZamowieniaSearchService {
    /**
     * Wyszukuje wszyskie pozycje zamówienia dla zamówienia o podanym Id
     * @param sessionId Id sesji
     * @param ID Id Zamówienia
     * @return Lista pozycji zamówienia
     * @throws AuthenticationException
     */
    List<PozycjaZamowieniaBO> findAllforZamowienie(String sessionId, Long ID) throws AuthenticationException;
}
