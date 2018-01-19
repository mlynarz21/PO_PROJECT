package com.StoreX.api;

public interface BilansApi {

	/**
	 * 
	 * @param sessionId
	 */
	org.springframework.http.ResponseEntity<com.StoreX.common.datatypes.to.BilansTO> getLastBilans(String sessionId);

	/**
	 * 
	 * @param dataBilansowana
	 * @param sessionId
	 */
	org.springframework.http.ResponseEntity<Boolean> addBilans(java.util.Date dataBilansowana, String sessionId);

	/**
	 * To be removed, created for test purposes
	 * @param dataBilansowana
	 * @param sessionId
	 */
	org.springframework.http.ResponseEntity<Long> addBilansTest(java.util.Date dataBilansowana, String sessionId);

	/**
	 * 
	 * @param sessionId
	 */
	org.springframework.http.ResponseEntity<java.util.List<com.StoreX.common.datatypes.to.PozycjaZamowieniaTO>> addTest(String sessionId);

}