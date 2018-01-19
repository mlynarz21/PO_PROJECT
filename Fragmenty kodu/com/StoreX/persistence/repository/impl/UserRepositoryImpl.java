package com.StoreX.persistence.repository.impl;

import com.StoreX.persistence.repository.AuthorizationRepository.*;

@Repository
public class UserRepositoryImpl implements UserRepository {

	private static final java.util.Map<String, java.util.UUID> userSessions;
	private static final java.util.Map<Long, com.StoreX.persistence.entity.AuthorizationEntities.User> mockedUsers;

	/**
	 * 
	 * @param sessionID
	 */
	@Override
	public boolean isUserAuthorized(java.util.UUID sessionID) {
		// TODO - implement UserRepositoryImpl.isUserAuthorized
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param username
	 * @param password
	 */
	@Override
	public java.util.UUID login(String username, String password) {
		// TODO - implement UserRepositoryImpl.login
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param newUser
	 */
	@Override
	public boolean register(com.StoreX.persistence.entity.AuthorizationEntities.User newUser) {
		// TODO - implement UserRepositoryImpl.register
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param newUser
	 */
	private boolean userAlreadyExists(com.StoreX.persistence.entity.AuthorizationEntities.User newUser) {
		// TODO - implement UserRepositoryImpl.userAlreadyExists
		throw new UnsupportedOperationException();
	}

	private Long getNewIndex() {
		// TODO - implement UserRepositoryImpl.getNewIndex
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param username
	 */
	@Override
	public String getUserType(String username) {
		// TODO - implement UserRepositoryImpl.getUserType
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param userName
	 */
	public boolean existsUser(String userName) {
		// TODO - implement UserRepositoryImpl.existsUser
		throw new UnsupportedOperationException();
	}

}