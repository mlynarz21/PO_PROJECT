package com.crashcourse.restclient.api.impl;

import java.net.URI;

import com.crashcourse.restclient.datatype.SessionTo;
import com.crashcourse.restclient.datatype.UserTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.crashcourse.restclient.api.AuthorizationRestServiceClient;

import com.crashcourse.restclient.main.config.StoreXSecurityContext;

/**
 * REST client odpowiadający za autoryzację (implementacja).
 */
@Component
public class AuthorizationRestServiceClientImpl implements AuthorizationRestServiceClient {
    @Value("${application.authorization.url}")
    private String serviceUrl;

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private StoreXSecurityContext context;

    /**
     * metoda odpowiadająca za autoryzację uzytkownika oraz jego zalogowanie
     * @param userName nazwa użytkownika
     * @param password haslo użytkownika
     * @return SessionTO - parametr identyfikujący usera podczas autoryzacji
     */
    @Override
    public SessionTo login(String userName, String password) {
        UserTo userTo = buildUserTo(userName, password);
        RequestEntity<UserTo> requestEntity =
                new RequestEntity<>(userTo, HttpMethod.POST, builLoginRequestUri());
        ResponseEntity<SessionTo> exchange = restTemplate.exchange(requestEntity, new ParameterizedTypeReference<SessionTo>() {
        });
        if(exchange.getStatusCode().equals(HttpStatus.OK)){
            SessionTo body = exchange.getBody();
            context.setSession(body);
            return body;
        }
        else {
        	SessionTo s = new SessionTo();
        	s.setUserName("100");
        	return s;
        }
    }

    /**
     * Metoda mapująca dane uzytkownika na klasę UserTO
     * @param userName nazwa użytkownika
     * @param password haslo użytkownika
     * @return userTo - obiekt transferowy typu User
     */
    private UserTo buildUserTo(String userName, String password) {
        UserTo userTo = new UserTo();
        userTo.setUsername(userName);
        userTo.setPassword(password);
        return userTo;
    }

    /**
     * metoda budująca URI dla servera
     * @return URI dla logowania
     */
    private URI builLoginRequestUri() {
        return URI.create(new StringBuilder().append(serviceUrl).append("/login/").toString());
    }
}
