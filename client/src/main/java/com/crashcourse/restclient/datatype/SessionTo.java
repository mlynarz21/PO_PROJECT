package com.crashcourse.restclient.datatype;

import java.util.UUID;

public class SessionTo {
    private UUID sessionId;
    
    private String userType;

    public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public SessionTo() {
    }

    public SessionTo(UUID sessionId) {
        this.sessionId = sessionId;
    }

    public UUID getSessionId() {
        return sessionId;
    }

    public void setSessionId(UUID sessionId) {
        this.sessionId = sessionId;
    }
}
