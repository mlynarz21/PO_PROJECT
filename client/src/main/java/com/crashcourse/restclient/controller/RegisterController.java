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
        authorizationRestServiceClient.login(username.getText(), password.getText());

        Optional.ofNullable(app.getSession()).orElseThrow(() -> new LoginException());

        FXMLDialog defaultDialog=null;
        if(app.getSession().getUserType().equals("admin"))
        		defaultDialog = getScreens().artifactListAdminDialog();
        else
        if(app.getSession().getUserType().equals("user"))
        		defaultDialog = getScreens().artifactListDialog();
        else
        	throw new LoginException();
        
        getDialog().close();
        getScreens().showDialog(defaultDialog);

    }
    
    @FXML
    public void back() {
    	FXMLDialog defaultDialog=getScreens().loginDialog();
        getDialog().close();
        getScreens().showDialog(defaultDialog);
    }

    @Override
    public String getResourcePath() {
        return "/com/crashcourse/restclient/controller/Register.fxml";
    }

}
