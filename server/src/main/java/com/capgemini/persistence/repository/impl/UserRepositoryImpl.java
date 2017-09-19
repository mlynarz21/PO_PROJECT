package com.capgemini.persistence.repository.impl;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.capgemini.persistence.entity.User;
import com.capgemini.persistence.repository.UserRepository;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private static final Map<String, UUID> userSessions;
    private static final Map<Long, User> mockedUsers;
    static {
        userSessions = new HashMap<String, UUID>();

        mockedUsers = new HashMap<Long, User>();
        mockedUsers.put(1L, new User(1L, "admin", "topsecret"));
        mockedUsers.put(2L, new User(2L, "user", "user"));
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
        mockedUsers.put(newIndex, newUser);

        return true;
    }

    private boolean userAlreadyExists(User newUser) {
        return mockedUsers.values().stream().filter(u -> u.getUsername().equals(newUser.getUsername())).findAny().isPresent();
    }

    private Long getNewIndex() {
        return mockedUsers.keySet().stream().sorted(new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                return o2.compareTo(o1);
            }
        }).findFirst().get();
    }

}
