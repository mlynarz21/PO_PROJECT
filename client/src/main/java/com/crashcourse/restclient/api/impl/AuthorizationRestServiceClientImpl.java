package com.crashcourse.restclient.api.impl;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.crashcourse.restclient.api.AuthorizationRestServiceClient;
import com.crashcourse.restclient.datatype.SessionTo;
import com.crashcourse.restclient.datatype.UserTo;
import com.crashcourse.restclient.main.config.LibrarySecurityContext;

public class AuthorizationRestServiceClientImpl implements AuthorizationRestServiceClient {
    @Value("${application.authorization.url}")
    private String serviceUrl;

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private LibrarySecurityContext context;

    @Override
    public SessionTo login(String userName, String password) {
        UserTo userTo = buildUserTo(userName, password);
        RequestEntity<UserTo> requestEntity =
                new RequestEntity<>(userTo, HttpMethod.POST, builLoginRequestUri());
        ResponseEntity<SessionTo> exchange = restTemplate.exchange(requestEntity, new ParameterizedTypeReference<SessionTo>() {
        });
        SessionTo body = exchange.getBody();
        context.setSession(body);
        return body;
    }

    private UserTo buildUserTo(String userName, String password) {
        UserTo userTo = new UserTo();
        userTo.setUsername(userName);
        userTo.setPassword(password);
        return userTo;
    }

    @Override
    public int register(String userName, String password) {
    	UserTo userTo = buildUserTo(userName, password);
        RequestEntity<UserTo> requestEntity =
                new RequestEntity<>(userTo, HttpMethod.POST, builRegisterRequestUri());
        ResponseEntity exchange = restTemplate.exchange(requestEntity, new ParameterizedTypeReference<SessionTo>() {
        });
        HttpStatus code = exchange.getStatusCode();
        if(code.equals(200)){
        	return 200;
        }else{
            return 100;     	
        }
    }
    
    private URI builLoginRequestUri() {
        return URI.create(new StringBuilder().append(serviceUrl).append("/login/").toString());
    }
    
    private URI builRegisterRequestUri() {
        return URI.create(new StringBuilder().append(serviceUrl).append("/register/").toString());
    }
}
