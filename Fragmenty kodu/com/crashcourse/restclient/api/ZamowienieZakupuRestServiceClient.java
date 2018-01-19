package com.crashcourse.restclient.api;

public interface ZamowienieZakupuRestServiceClient {

	java.util.List<com.crashcourse.restclient.datatype.ZamowienieZakupuTO> getAllZaakceptowane();

	/**
	 * 
	 * @param ID
	 */
	void updateStatusZamowienieZakupu(Long ID);

}