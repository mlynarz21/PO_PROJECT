package com.crashcourse.restclient.api;

import com.crashcourse.restclient.datatype.BilansTO;

import java.util.Date;

/**
 * REST client odpiwiadający za bilans REST service.
 */
public interface BilansRestServiceClient {

    /**
     * metoda pobierająca Bilans za ostatni bilansowany miesiąc znajdujący się w bazie danych
     * @return BilansTO - obiekt transferowy Bilansu zawierający dane o ostatnim bilansie
     */
    BilansTO getLastBilans();

    /**
     * metoda dodająca nowy bilans za wskazany w parametrze miesiąc do bazy danych
     * @param dataBilansowana data miesiąca bilansowanego
     */
    void addBilans(Date dataBilansowana);
}
