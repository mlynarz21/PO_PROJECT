package com.crashcourse.restclient.api;

import com.crashcourse.restclient.datatype.SessionTo;

/**
 * REST client odpowiadający za autoryzację.
 *
 */
public interface AuthorizationRestServiceClient {

    /**
     * metoda odpowiadająca za autoryzację uzytkownika oraz jego zalogowanie
     * @param userName nazwa użytkownika
     * @param password haslo użytkownika
     * @return SessionTO - parametr identyfikujący usera podczas autoryzacji
     */
    SessionTo login(String userName, String password);

}
