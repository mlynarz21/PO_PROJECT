package com.capgemini.api;

import org.springframework.http.ResponseEntity;

import com.capgemini.common.datatypes.to.SessionTo;
import com.capgemini.common.datatypes.to.UserTo;

/**
 * REST Api used for authorization.
 * @author CWOJTOWI
 */
public interface AuthorizationApi {

    /**
     * Logs users in. If the user is logged in correctly a sessionID is returned.
     *
     * @param user
     * @return
     */
    ResponseEntity<SessionTo> login(UserTo user);

    /**
     * Used to register a new user. This method validates that all needed data is filled.
     *
     * @param user
     * @return true if the user was correctly registered
     */
    ResponseEntity<?> register(UserTo user);
}
