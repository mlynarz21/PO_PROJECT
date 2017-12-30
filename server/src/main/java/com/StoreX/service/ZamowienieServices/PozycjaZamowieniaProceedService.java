package com.StoreX.service.ZamowienieServices;

import javax.naming.AuthenticationException;

public interface PozycjaZamowieniaProceedService {
    boolean ProceedPozycjaZamowienia(String sessionId, Long idPozycji, Long idUmieszczenia, double ilosc) throws AuthenticationException, Exception;
}
