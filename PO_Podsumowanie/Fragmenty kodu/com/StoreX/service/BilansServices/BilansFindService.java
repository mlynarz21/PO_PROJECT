package com.StoreX.service.BilansServices;

public interface BilansFindService {

	/**
	 * 
	 * @param sessionId
	 */
	com.StoreX.common.datatypes.bo.BilansBO findLast(String sessionId) throws javax.naming.AuthenticationException;

}