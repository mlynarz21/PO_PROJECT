package com.StoreX.persistence.repository.impl;

import com.StoreX.persistence.entity.AuthorizationEntities.User;
import com.StoreX.persistence.repository.AuthorizationRepository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private static final Map<String, UUID> userSessions;
    private static final Map<Long, User> mockedUsers;
    static {
        userSessions = new HashMap<>();
        mockedUsers = new HashMap<>();
        mockedUsers.put(1L, new User(1L, "admin", "topsecret", "admin"));
        mockedUsers.put(2L, new User(2L, "user", "user", "user"));
        mockedUsers.put(3L, new User(3L, "jan", "kowalski", "user"));
    }

    @Override
    public boolean isUserAuthorized(UUID sessionID) {
        return userSessions.containsValue(sessionID);
    }

    @Override
    public UUID login(String username, String password) {
        Optional<User> foundUser = mockedUsers.values().stream().filter(user -> user.getUsername().equals(username)).findAny();

        if (foundUser.isPresent() && foundUser.get().getPassword().equals(password)) {
            if (userSessions.containsKey(username)) {
                return userSessions.get(username);
            } else {
                UUID generatedID = UUID.randomUUID();
                userSessions.put(username, generatedID);
                return generatedID;
            }
        }
        return null;
    }

    @Override
    public boolean register(User newUser) {
        if (userAlreadyExists(newUser)) {
            return false;
        }

        Long newIndex = getNewIndex();
        newUser.setId(newIndex);
        mockedUsers.put(newIndex, new User(newIndex, newUser.getUsername(), newUser.getPassword(), "user"));

        return true;
    }

    private boolean userAlreadyExists(User newUser) {
        return mockedUsers.values().stream().filter(u -> u.getUsername().equals(newUser.getUsername())).findAny().isPresent();
    }

    private Long getNewIndex() {
        return mockedUsers.keySet().stream().sorted((o1, o2) -> o2.compareTo(o1)).findFirst().get();
    }

	@Override
	public String getUserType(String username) {
		if(existsUser(username))
        return mockedUsers.values().stream().filter(user -> user.getUsername().equals(username)).findFirst().get().getUserType();
	    return null;
	}
	public boolean existsUser(String userName){
		//return true;
		return mockedUsers.values().stream().filter(u -> u.getUsername().equals(userName)).count()>0;
	}

}
