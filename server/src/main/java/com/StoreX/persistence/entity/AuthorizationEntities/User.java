package com.StoreX.persistence.entity.AuthorizationEntities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

/**
 * User Entity
 * @author CWOJTOWI
 */
@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Size(max = 32)
    private String username;

    @Size(max = 32)
    private String password;
    
    @Size(max=32)
    private String userType;

    public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public User() {

    }

    public User(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
    
    public User(Long id, String username, String password, String userType) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.userType = userType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
