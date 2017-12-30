package com.StoreX.service.PozycjeWydanPrzyjecServices;

import com.StoreX.common.datatypes.bo.PozycjaPrzyjeciaBO;

import javax.naming.AuthenticationException;
import java.util.List;

public interface PozycjaPrzyjeciaFindService {
    List<PozycjaPrzyjeciaBO> findAllForMonthAndYear(int Month, int Year) throws AuthenticationException;
}
