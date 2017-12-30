package com.StoreX.service.HelperServices;

import com.StoreX.common.datatypes.bo.PozycjaPrzyjeciaBO;
import com.StoreX.persistence.entity.PozycjaPrzyjecia;

import javax.naming.AuthenticationException;
import java.util.List;

public interface PozycjaPrzyjeciaService {



    void add(PozycjaPrzyjecia pozycjaPrzyjecia);
}
