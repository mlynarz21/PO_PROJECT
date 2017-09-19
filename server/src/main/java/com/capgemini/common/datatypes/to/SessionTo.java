package com.capgemini.common.datatypes.to;

import java.util.UUID;

/**
 * Session Transport Object
 * @author CWOJTOWI
 */
public class SessionTo {
    private UUID sessionId;

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
