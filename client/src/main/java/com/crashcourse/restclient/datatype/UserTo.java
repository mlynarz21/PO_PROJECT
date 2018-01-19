package com.crashcourse.restclient.datatype;

/**
 * klasa User obiektu transferowego - używana w komunikacji między serwerem a klientem
 */
public class UserTo {

    private Long id;

    private String username;

    private String password;
    
    private String userType;

    public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

    /**
     * pobiera ID uzytkownika
     * @return id
     */
	public Long getId() {
        return id;
    }

    /**
     * ustawia nowe ID uzytkownika
     * @param id nowe id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * pobiera nazwę użytkownika
     * @return nazwa użytkownika
     */
    public String getUsername() {
        return username;
    }

    /**
     * ustawia nazwę użytkownika
     * @param username nowa nazwa użytkownika
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * pobiera hasło użytkownika
     * @return hasło
     */
    public String getPassword() {
        return password;
    }

    /**
     * ustawia hasło użytkownika
     * @param password nowe hasło użytkownika
     */
    public void setPassword(String password) {
        this.password = password;
    }

}
