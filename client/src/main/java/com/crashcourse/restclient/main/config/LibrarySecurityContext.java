package com.crashcourse.restclient.main.config;

import com.crashcourse.restclient.datatype.SessionTo;

/**
 * Context holding the security information of the client.
 */
public class LibrarySecurityContext {

    private SessionTo session = null;

    public SessionTo getSession() {
        return session;
    }

    public void setSession(SessionTo session) {
        this.session = session;
    }

}
