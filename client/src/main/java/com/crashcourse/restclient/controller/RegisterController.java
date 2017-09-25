package com.crashcourse.restclient.controller;

import java.util.Optional;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;

import com.crashcourse.restclient.api.AuthorizationRestServiceClient;
import com.crashcourse.restclient.main.config.LibrarySecurityContext;
import com.crashcourse.restclient.view.FXMLDialog;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegisterController extends ArtifactsBaseController {

    @Autowired
    LibrarySecurityContext app;

    @Autowired
    private AuthorizationRestServiceClient authorizationRestServiceClient;
    @FXML
    PasswordField password;
    @FXML
    TextField username;

    public RegisterController(Stage primaryStage) {
        super(primaryStage);
    }

    @FXML
    public void register() throws LoginException {
        int code = authorizationRestServiceClient.register(username.getText(), password.getText());
        
        System.out.println(code);
        FXMLDialog defaultDialog=null;
        if(code == 200)
         defaultDialog = getScreens().loginDialog();
        else
        	//TODO ada
        
        getDialog().close();
        getScreens().showDialog(defaultDialog);

    }

    @Override
    public String getResourcePath() {
        return "/com/crashcourse/restclient/controller/Register.fxml";
    }

}
