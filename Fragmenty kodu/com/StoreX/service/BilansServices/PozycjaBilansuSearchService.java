package com.StoreX.service.BilansServices;

public interface PozycjaBilansuSearchService {

	/**
	 * 
	 * @param id
	 */
	java.util.List<com.StoreX.common.datatypes.bo.PozycjaBilansuBO> findAllForBilans(Long id) throws javax.naming.AuthenticationException;

}