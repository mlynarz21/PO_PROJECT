package com.StoreX.service.PozycjeWydanPrzyjecServices;

public interface PozycjaWydaniaFindService {

	/**
	 * 
	 * @param Month
	 * @param Year
	 */
	java.util.List<com.StoreX.common.datatypes.bo.PozycjaWydaniaBO> findAllForMonthAndYear(int Month, int Year) throws javax.naming.AuthenticationException;

}