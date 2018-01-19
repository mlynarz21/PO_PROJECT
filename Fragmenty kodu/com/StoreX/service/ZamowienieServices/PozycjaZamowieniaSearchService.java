package com.StoreX.service.ZamowienieServices;

public interface PozycjaZamowieniaSearchService {

	/**
	 * 
	 * @param sessionId
	 * @param ID
	 */
	java.util.List<com.StoreX.common.datatypes.bo.PozycjaZamowieniaBO> findAllforZamowienie(String sessionId, Long ID) throws javax.naming.AuthenticationException;

}