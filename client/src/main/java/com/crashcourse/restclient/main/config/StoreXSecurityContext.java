package com.crashcourse.restclient.main.config;

import com.crashcourse.restclient.datatype.enumeration.SessionTo;

/**
 * Context holding the security information of the client.
 */
public class StoreXSecurityContext {

    private SessionTo session = null;

    public SessionTo getSession() {
        return session;
    }

    public void setSession(SessionTo session) {
        this.session = session;
    }
    
    public void deleteSession(){
    	this.session=null;
    }

}
