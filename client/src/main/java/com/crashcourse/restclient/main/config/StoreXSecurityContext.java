package com.crashcourse.restclient.main.config;

import com.crashcourse.restclient.datatype.SessionTo;

/**
 * Context holding the security information of the client.
 */
public class StoreXSecurityContext {

    private SessionTo session = null;

    /**
     * metoda pobierająca aktualną sesję użytkownika
     * @return SessionTO
     */
    public SessionTo getSession() {
        return session;
    }

    /**
     * metoda ustawiająca sesję użytkownika
     * @param session sesja uzytkownika
     */
    public void setSession(SessionTo session) {
        this.session = session;
    }

    /**
     * metoda usuwająca aktualną sesję
     */
    public void deleteSession(){
    	this.session=null;
    }

}
