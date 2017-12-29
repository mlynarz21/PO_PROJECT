package com.StoreX.service;

import com.StoreX.common.datatypes.bo.PozycjaWydaniaBO;
import com.StoreX.persistence.entity.PozycjaPrzyjecia;
import com.StoreX.persistence.entity.PozycjaWydania;

import javax.naming.AuthenticationException;
import java.util.List;

public interface PozycjaWydaniaService {
    List<PozycjaWydaniaBO> findAllForMonthAndYear(int Month, int Year) throws AuthenticationException;

    void add(PozycjaWydania pozycjaWydania);
}
