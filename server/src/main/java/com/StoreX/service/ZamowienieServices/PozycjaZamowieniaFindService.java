package com.StoreX.service.ZamowienieServices;

import com.StoreX.common.datatypes.bo.PozycjaZamowieniaBO;

import javax.naming.AuthenticationException;
import java.util.List;

public interface PozycjaZamowieniaFindService {
    List<PozycjaZamowieniaBO> findAllforZamowienie(String sessionId, Long ID) throws AuthenticationException;
}
