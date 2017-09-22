package com.capgemini.common.datatypes.to;

import java.util.UUID;

/**
 * Session Transport Object
 * @author CWOJTOWI
 */
public class SessionTo {
    private UUID sessionId;
    private String userType;

    public SessionTo(UUID sessionId, String userType) {
        this.sessionId = sessionId;
        this.userType = userType;
    }

    public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public UUID getSessionId() {
        return sessionId;
    }

    public void setSessionId(UUID sessionId) {
        this.sessionId = sessionId;
    }
}
