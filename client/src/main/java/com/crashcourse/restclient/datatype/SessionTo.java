package com.crashcourse.restclient.datatype;

import java.util.UUID;

public class SessionTo {
    private UUID sessionId;

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
