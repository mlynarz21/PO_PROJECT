package com.StoreX.service.BilansServices;

import com.StoreX.common.datatypes.bo.PozycjaBilansuBO;

import javax.naming.AuthenticationException;
import java.util.List;

public interface PozycjaBilansuSearchService {
    /**
     * Wyszukuje pozycje bilansu dla bilansu o podanym Id
     * @param id Bilnasu
     * @return Lista pozycji bilansu
     * @throws AuthenticationException
     */
    List<PozycjaBilansuBO> findAllForBilans(Long id) throws AuthenticationException;
}
