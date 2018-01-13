package com.crashcourse.restclient.api;

import com.crashcourse.restclient.datatype.UmieszczenieTO;

import java.util.List;

/**
 * REST client odpiwiadający za umieszczenie REST service.
 */
public interface UmieszczenieRestServiceClient {

    /**
     * metoda pobierająca liste umieszczeń towaru o podanym ID
     * @param IDTowaru id towaru, którego mają dotyczyć umieszczenia
     * @return lista umieszczeń towaru o podanym ID
     */
    List<UmieszczenieTO> getUmieszczenieTowaru(Long IDTowaru);

}
