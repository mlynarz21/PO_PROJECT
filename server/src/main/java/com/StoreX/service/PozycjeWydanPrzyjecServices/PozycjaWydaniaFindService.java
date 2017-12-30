package com.StoreX.service.PozycjeWydanPrzyjecServices;

import com.StoreX.common.datatypes.bo.PozycjaWydaniaBO;

import javax.naming.AuthenticationException;
import java.util.List;

public interface PozycjaWydaniaFindService {
    List<PozycjaWydaniaBO> findAllForMonthAndYear(int Month, int Year) throws AuthenticationException;
}
