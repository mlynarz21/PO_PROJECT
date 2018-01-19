package com.StoreX.service.ZamowienieServices;

public interface ZamowienieZakupuFindService {

	/**
	 * 
	 * @param sessionId
	 */
	java.util.List<com.StoreX.common.datatypes.bo.ZamowienieZakupuBO> findAllAccepted(String sessionId) throws javax.naming.AuthenticationException;

}