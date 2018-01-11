package com.StoreX.service.ZamowienieServices;

import javax.naming.AuthenticationException;

public interface PozycjaZamowieniaProceedService {
    /**
     * Pobiera podaną ilość z podanej lokalizacji i zwiększa ilość zrealizowaną w podanej pozycji zamóienia
     * @param sessionId Id sesji
     * @param idPozycji Id pozycji zamówienia
     * @param idUmieszczenia Id umieszczenia
     * @param ilosc Ilosć
     * @return Informacja o powodzeniu operacji
     * @throws AuthenticationException
     * @throws Exception
     */
    boolean ProceedPozycjaZamowienia(String sessionId, Long idPozycji, Long idUmieszczenia, double ilosc) throws AuthenticationException, Exception;
}
