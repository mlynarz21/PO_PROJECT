package com.crashcourse.restclient.api;

public interface PozycjaZamowieniaRestServiceClient {

	/**
	 * 
	 * @param idPozycji
	 * @param idUmieszcznia
	 * @param ilosc
	 */
	void proceedPozycjaZamowienia(Long idPozycji, Long idUmieszcznia, double ilosc);

	/**
	 * 
	 * @param ID
	 */
	java.util.List<com.crashcourse.restclient.datatype.PozycjaZamowieniaTO> getPozycjeZamowienia(Long ID);

}