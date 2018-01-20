package com.StoreX.persistence.repository.AuthorizationRepository;

import java.util.UUID;

import com.StoreX.persistence.entity.AuthorizationEntities.User;

/**
 * Repozytorium używane do akcji z bazą danych oraz User Entity.
 */
public interface UserRepository {

    /**
     *  Sprawdza czy sessionID jest poprawne - czy użytkownik ma autoryzację
     *
     * @param sessionID sessionID użytkownika
     * @return
     */
    boolean isUserAuthorized(UUID sessionID);

    /**
     * Loguje użytkownika. jeśli proces przebiega poprawnie - zwraca sessionID
     *
     * @param username nazwa użytkownika
     * @param password
     * @return numer sesji użytkownika
     */
    UUID login(String username, String password);

    boolean register(User newUser);
    
    String getUserType(String username);
}
