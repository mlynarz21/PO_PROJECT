package com.StoreX.service.PozycjeWydanPrzyjecServices;

public interface PozycjaPrzyjeciaSearchService {

	/**
	 * 
	 * @param Month
	 * @param Year
	 */
	java.util.List<com.StoreX.common.datatypes.bo.PozycjaPrzyjeciaBO> findAllForMonthAndYear(int Month, int Year) throws javax.naming.AuthenticationException;

}