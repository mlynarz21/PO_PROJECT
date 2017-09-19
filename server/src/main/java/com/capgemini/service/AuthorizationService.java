package com.capgemini.service;

import java.util.UUID;

import com.capgemini.common.datatypes.bo.UserBo;

/**
 * Service which is responsible for the logic of the authorization process of Users.
 * @author CWOJTOWI
 */
public interface AuthorizationService {

    /**
     * Logs users in. If the user is logged in correctly a sessionID is returned.
     *
     * @param username
     * @param password
     * @return sessionId
     */
    public UUID login(UserBo user);

    /**
     * Used to register a new user. This method validates that all needed data is filled.
     *
     * @param newUser
     * @return true if the user was correctly registered
     */
    public boolean register(UserBo newUser);

    /**
     *  Checks if the given sessionID is valid - if the user is correctly authorized.
     *
     * @param sessionID the sessionID of the User
     * @return true if the sessionId is valid
     */
    boolean isUserAuthorized(UUID sessionID);

}
