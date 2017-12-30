package com.StoreX.service.HelperServices;

import com.StoreX.common.datatypes.bo.PozycjaWydaniaBO;
import com.StoreX.persistence.entity.PozycjaPrzyjecia;
import com.StoreX.persistence.entity.PozycjaWydania;

import javax.naming.AuthenticationException;
import java.util.List;

public interface PozycjaWydaniaService {

    void add(PozycjaWydania pozycjaWydania);
}
