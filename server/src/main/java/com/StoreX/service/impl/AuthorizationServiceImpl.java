package com.StoreX.service.impl;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.StoreX.common.datatypes.bo.UserBo;
import com.StoreX.persistence.entity.User;
import com.StoreX.persistence.repository.UserRepository;
import com.StoreX.service.AuthorizationService;

@Service
public class AuthorizationServiceImpl implements AuthorizationService {

    @Autowired
    private UserRepository userRepository;

    private ModelMapper mapper = new ModelMapper();

    @Override
    public UUID login(UserBo user) {
        if (userValid(user)) {
            return userRepository.login(user.getUsername(), user.getPassword());
        }
        return null;
    }
    
    public String getUserType(String userName){
    	return userRepository.getUserType(userName);
    }

    @Override
    public boolean register(UserBo newUser) {
        if (userValid(newUser) && newUser.getId()==null ) {
            return userRepository.register(mapper.map(newUser, User.class));
        }
        return false;
    }

    @Override
    public boolean isUserAuthorized(UUID sessionID) {
        return userRepository.isUserAuthorized(sessionID);
    }

    private boolean userValid(UserBo user) {
        return user != null
                && StringUtils.hasText(user.getPassword())
                && StringUtils.hasText(user.getUsername());
    }


}
