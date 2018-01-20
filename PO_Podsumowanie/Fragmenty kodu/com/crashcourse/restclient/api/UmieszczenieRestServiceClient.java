package com.crashcourse.restclient.api;

public interface UmieszczenieRestServiceClient {

	/**
	 * 
	 * @param IDTowaru
	 */
	java.util.List<com.crashcourse.restclient.datatype.UmieszczenieTO> getUmieszczenieTowaru(Long IDTowaru);

}