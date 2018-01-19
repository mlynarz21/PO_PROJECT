package com.StoreX.service.ZamowienieServices;

public interface PozycjaZamowieniaProceedService {

	/**
	 * 
	 * @param sessionId
	 * @param idPozycji
	 * @param idUmieszczenia
	 * @param ilosc
	 */
	boolean ProceedPozycjaZamowienia(String sessionId, Long idPozycji, Long idUmieszczenia, double ilosc) throws javax.naming.AuthenticationException, Exception;

}