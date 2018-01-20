package com.StoreX.service.UmieszczenieServices;

public interface UmieszczenieFindService {

	/**
	 * 
	 * @param sessionId
	 * @param ID
	 */
	java.util.List<com.StoreX.common.datatypes.bo.UmieszczenieBO> findAllForTowar(String sessionId, Long ID) throws javax.naming.AuthenticationException;

}