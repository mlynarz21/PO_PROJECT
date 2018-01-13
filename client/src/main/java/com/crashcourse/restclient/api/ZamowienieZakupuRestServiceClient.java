package com.crashcourse.restclient.api;

import com.crashcourse.restclient.datatype.ZamowienieZakupuTO;

import java.util.List;

/**
 * REST client odpiwiadający za zamowienieZakupu REST service.
 */
public interface ZamowienieZakupuRestServiceClient {

    /**
     * metoda pobierająca wszystkie zamówienia w statusie Zaakceptowane
     * @return lista zaakceptowanych zamówień zakupu w bazie
     */
    List<ZamowienieZakupuTO> getAllZaakceptowane();

    /**
     * metoda zmieniająca status zamówienia zakupu o podanym ID na Gotowe
     * @param ID id zamówienia , którego dotyczyć będzie zmiana
     */
    void updateStatusZamowienieZakupu(Long ID);
}
