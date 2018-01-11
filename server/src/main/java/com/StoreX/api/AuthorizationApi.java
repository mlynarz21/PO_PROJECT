package com.StoreX.api;

import org.springframework.http.ResponseEntity;

import com.StoreX.common.datatypes.to.SessionTo;
import com.StoreX.common.datatypes.to.UserTo;

/**
 * REST Api used for authorization.
 * @author CWOJTOWI
 */
public interface AuthorizationApi {

    /**
     * Loguje użytkownika. Jeżeli użytkownik zostanie zalogowany poprawnie, zwracane jest Id sesji
     *
     * @param user
     * @return
     */
    ResponseEntity<SessionTo> login(UserTo user);

    /**
     * Rejestruje nowego użytkownika
     *
     * @param user
     * @return true if the user was correctly registered
     */
    ResponseEntity<?> register(UserTo user);
}
