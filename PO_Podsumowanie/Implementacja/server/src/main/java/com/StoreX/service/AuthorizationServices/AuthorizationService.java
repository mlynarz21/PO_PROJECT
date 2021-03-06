package com.StoreX.service.AuthorizationServices;

import java.util.UUID;

import com.StoreX.common.datatypes.bo.UserBo;

/**
 * Service which is responsible for the logic of the authorization process of Users.
 */
public interface AuthorizationService {

    /**
     * Logs users in. If the user is logged in correctly a sessionID is returned.
     * @return sessionId
     */
    UUID login(UserBo user);

    /**
     * Used to register a new user. This method validates that all needed data is filled.
     *
     * @param newUser
     * @return true if the user was correctly registered
     */
    boolean register(UserBo newUser);

    /**
     *  Checks if the given sessionID is valid - if the user is correctly authorized.
     *
     * @param sessionID the sessionID of the User
     * @return true if the sessionId is valid
     */
    boolean isUserAuthorized(UUID sessionID);
    
    String getUserType(String userName);

}
