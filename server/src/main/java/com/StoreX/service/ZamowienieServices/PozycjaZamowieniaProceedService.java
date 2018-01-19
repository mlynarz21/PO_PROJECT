package com.StoreX.service.ZamowienieServices;

import javax.naming.AuthenticationException;

public interface PozycjaZamowieniaProceedService {
    /**
     * Pobiera podaną ilość z podanej lokalizacji i zwiększa ilość zrealizowaną w podanej pozycji zamóienia
     * @param sessionId Id sesji użytkownika wysyłąjącego zapytanie
     * @param idPozycji Id pozycji zamówienia, którego dotyczy zapytanie
     * @param idUmieszczenia Id umieszczenia, którgo dotyczy zapytanie
     * @param ilosc Ilość dekrementowana w umieszczeniu, a zarazem inkrementowana w zamówieniu
     * @return Informacja o powodzeniu operacji
     * @throws AuthenticationException
     * @throws Exception
     */
    boolean ProceedPozycjaZamowienia(String sessionId, Long idPozycji, Long idUmieszczenia, double ilosc) throws AuthenticationException, Exception;
}
