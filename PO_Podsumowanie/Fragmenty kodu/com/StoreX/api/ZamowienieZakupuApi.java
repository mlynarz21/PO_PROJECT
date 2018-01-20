package com.StoreX.api;

public interface ZamowienieZakupuApi {

	/**
	 * 
	 * @param sessionId
	 */
	org.springframework.http.ResponseEntity<java.util.List<com.StoreX.common.datatypes.to.ZamowienieZakupuTO>> getAllZaakceptowane(String sessionId);

	/**
	 * 
	 * @param ID
	 * @param sessionId
	 */
	org.springframework.http.ResponseEntity<Boolean> updateStatusZamowienieZakupu(Long ID, String sessionId);

}