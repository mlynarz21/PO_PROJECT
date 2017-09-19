package com.crashcourse.restclient.api;

import com.crashcourse.restclient.datatype.SessionTo;

/**
 * REST client for the artifact REST service.
 *
 * @author Mateusz
 */
public interface AuthorizationRestServiceClient {

    /**
     * Logs users in. If the user is logged in correctly a sessionID is returned.
     *
     * @param user
     * @return
     */
    SessionTo login(String userName, String password);

    /**
     * Used to register a new user. This method validates that all needed data is filled.
     *
     * @param user
     * @return true if the user was correctly registered
     */
    void register(String userName, String password);
}
