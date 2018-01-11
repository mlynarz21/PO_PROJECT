package com.StoreX.service.PozycjeWydanPrzyjecServices;

import com.StoreX.common.datatypes.bo.PozycjaPrzyjeciaBO;

import javax.naming.AuthenticationException;
import java.util.List;

public interface PozycjaPrzyjeciaSearchService {
    /**
     * Wyszukuje wszystkie pozycje przyjęcia dla podanego roku i miesiąca
     * @param Month
     * @param Year
     * @return
     * @throws AuthenticationException
     */
    List<PozycjaPrzyjeciaBO> findAllForMonthAndYear(int Month, int Year) throws AuthenticationException;
}
