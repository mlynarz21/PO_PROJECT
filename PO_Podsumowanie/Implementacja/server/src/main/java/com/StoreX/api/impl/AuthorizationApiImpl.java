package com.StoreX.api.impl;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.StoreX.api.AuthorizationApi;
import com.StoreX.common.datatypes.bo.UserBo;
import com.StoreX.common.datatypes.to.SessionTo;
import com.StoreX.common.datatypes.to.UserTo;
import com.StoreX.service.AuthorizationServices.AuthorizationService;


@CrossOrigin
@RestController
@RequestMapping("/rest/artifactlibrary/authorization/v1")
/**
 * REST Api użwane do autoryzacji(implementacja)
 */
public class AuthorizationApiImpl implements AuthorizationApi {

    @Autowired
    private AuthorizationService authorizationService;

    private ModelMapper mapper = new ModelMapper();

    /**
     * Loguje użytkownika. Jeżeli użytkownik zostanie zalogowany poprawnie, zwracane jest Id sesji
     *
     * @param user
     * @return Id sesji użytkownika
     */
    @Override
    @RequestMapping(value = "/login/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SessionTo> login(@RequestBody UserTo user) {
        UUID sessionId = authorizationService.login(mapper.map(user, UserBo.class));
        String userName = (mapper.map(user, UserBo.class)).getUsername();
        String userType = authorizationService.getUserType(userName);    
        SessionTo body = new SessionTo(sessionId, userType, userName);
        if(sessionId != null) {
        	if(userType!= null)
            return new ResponseEntity<>(body, HttpStatus.OK);
        	else 
                return new ResponseEntity<>(body, HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(body, HttpStatus.FOUND);
        }
    }

    /**
     * Rejestruje nowego użytkownika
     *
     * @param user
     * @return true jeśli użytkownik został poprawnie zarejestrowany
     */
    @Override
    @RequestMapping(value = "/register/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> register(@RequestBody UserTo user) {
    	boolean registered = false;
        registered = authorizationService.register(mapper.map(user, UserBo.class));
        System.out.println(registered);
        if (registered) {
            return new ResponseEntity<HttpStatus>(HttpStatus.OK);
        } else {
            return new ResponseEntity<HttpStatus>(HttpStatus.FOUND);
        }
    }
}
