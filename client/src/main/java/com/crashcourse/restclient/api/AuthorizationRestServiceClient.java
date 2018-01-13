package com.crashcourse.restclient.api;

import com.crashcourse.restclient.datatype.SessionTo;

/**
 * REST client odpowiadający za autoryzację.
 *
 */
public interface AuthorizationRestServiceClient {

    /**
     * metoda odpowiadająca za autoryzację uzytkownika oraz jego zalofowanie
     * @param userName username
     * @param password haslo
     * @return SessionTO
     */
    SessionTo login(String userName, String password);

}
