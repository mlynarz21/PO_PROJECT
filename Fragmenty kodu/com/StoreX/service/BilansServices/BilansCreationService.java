package com.StoreX.service.BilansServices;

public interface BilansCreationService {

	/**
	 * 
	 * @param sessionId
	 * @param dataBilansowana
	 */
	boolean addBilans(String sessionId, java.util.Date dataBilansowana) throws javax.naming.AuthenticationException, Exception;

}