package com.StoreX.api;

public interface PozycjaZamowieniaApi {

	/**
	 * 
	 * @param ID
	 * @param sessionId
	 */
	org.springframework.http.ResponseEntity<java.util.List<com.StoreX.common.datatypes.to.PozycjaZamowieniaTO>> getPozycjeZamowienia(Long ID, String sessionId);

	/**
	 * ResponseEntity<Boolean> updatePozycjaZamowienia(PozycjaZamowieniaTO pozycjaZamowienia, String sessionId);
	 * 
	 * 
	 * ResponseEntity<Boolean> proceedPozycjaZamowienia(  Long idPozycji, Long idUmieszczniea, double ilosc, String sessionId);
	 * @param transferList
	 * @param sessionId
	 */
	org.springframework.http.ResponseEntity<Boolean> proceedPozycjaZamowienia(java.util.List<Double> transferList, String sessionId);

}