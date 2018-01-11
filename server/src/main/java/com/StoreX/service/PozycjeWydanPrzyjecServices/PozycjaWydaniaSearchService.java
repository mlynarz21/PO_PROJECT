package com.StoreX.service.PozycjeWydanPrzyjecServices;

import com.StoreX.common.datatypes.bo.PozycjaWydaniaBO;

import javax.naming.AuthenticationException;
import java.util.List;

public interface PozycjaWydaniaSearchService {
    /**
     * Wyszukuje wszystkie pozycje wydania dla podanego roku i miesiąca
     * @param Month
     * @param Year
     * @return
     * @throws AuthenticationException
     */
    List<PozycjaWydaniaBO> findAllForMonthAndYear(int Month, int Year) throws AuthenticationException;
}
