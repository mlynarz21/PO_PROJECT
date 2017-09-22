package com.capgemini.common.datatypes.to;

import java.util.UUID;

/**
 * Session Transport Object
 * @author CWOJTOWI
 */
public class SessionTo {
    private UUID sessionId;
    private String userType;
    private String userName;

    public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public SessionTo(UUID sessionId, String userType, String userName) {
        this.sessionId = sessionId;
        this.userType = userType;
        this.userName = userName;
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
