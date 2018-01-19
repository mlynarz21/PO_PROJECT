package com.StoreX.api;

public interface UmieszczenieApi {

	/**
	 * 
	 * @param id
	 * @param sessionId
	 */
	org.springframework.http.ResponseEntity<java.util.List<com.StoreX.common.datatypes.to.UmieszczenieTO>> getUmieszczenieTowaru(Long id, String sessionId);

}