package com.StoreX.service.ZamowienieServices;

public interface ZamowienieZakupuUpdateService {

	/**
	 * 
	 * @param sessionId
	 * @param ID
	 */
	void updateStatusZamowienia(String sessionId, Long ID) throws javax.naming.AuthenticationException;

}