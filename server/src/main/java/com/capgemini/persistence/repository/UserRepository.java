package com.capgemini.persistence.repository;

import java.util.UUID;

import com.capgemini.persistence.entity.User;

/**
 * Repository used for Database actions with the User Entity.
 * @author CWOJTOWI
 */
public interface UserRepository {

    /**
     *  Checks if the given sessionID is valid - if the user is correctly authorized.
     *
     * @param sessionID the sessionID of the User
     * @return
     */
    boolean isUserAuthorized(UUID sessionID);

    /**
     * Logs users in. If the user is logged in correctly a sessionID is returned.
     *
     * @param username
     * @param password
     * @return
     */
    UUID login(String username, String password);

    /**
     * Registers a new user
     *
     * @param newUser
     * @return true if the user was correctly registered
     */
    boolean register(User newUser);
}
