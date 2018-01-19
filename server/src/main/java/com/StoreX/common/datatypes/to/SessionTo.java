package com.StoreX.common.datatypes.to;

import java.util.UUID;

/**
 * klasa Session obiektu transferowego - używana w komunikacji między serwerem a klientem. Odpowiada bezpośrednio za autoryzację użytkownika po stronie serwera
 */
public class SessionTo {
    private UUID sessionId;
    private String userType;
    private String userName;

    /**
     * pobiera nazwę użytkownika przypisanego do sesji
     * @return nazwa użytkownika sesji
     */
    public String getUserName() {
		return userName;
	}

    /**
     * ustawia użytkownika związanego z sesją
     * @param userName nowa nazwa użytkownika
     */
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

    /**
     * pobiera aktualną sesję
     * @return numer sesji
     */
	public UUID getSessionId() {
        return sessionId;
    }

    /**
     * ustawia nowy numer sesji
     * @param sessionId nowy numer sesji
     */
    public void setSessionId(UUID sessionId) {
        this.sessionId = sessionId;
    }
}
