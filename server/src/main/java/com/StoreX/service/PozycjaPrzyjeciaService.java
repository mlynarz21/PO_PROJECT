package com.StoreX.service;

import com.StoreX.common.datatypes.bo.PozycjaPrzyjeciaBO;
import com.StoreX.persistence.entity.PozycjaPrzyjecia;

import javax.naming.AuthenticationException;
import java.util.List;

public interface PozycjaPrzyjeciaService {

    List<PozycjaPrzyjeciaBO> findAllForMonthAndYear(int Month, int Year) throws AuthenticationException;

    void add(PozycjaPrzyjecia pozycjaPrzyjecia);
}
