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

public class WelcomeController extends ArtifactsBaseController {

    @Autowired
    LibrarySecurityContext app;

    @Autowired
    private AuthorizationRestServiceClient authorizationRestServiceClient;
    @FXML
    PasswordField password;
    @FXML
    TextField username;

    public WelcomeController(Stage primaryStage) {
        super(primaryStage);
    }

    @FXML
    public void proceed() throws LoginException {
    	
    	FXMLDialog defaultDialog=null;
    	if(username.getText().equals("") || password.getText().equals("")){
    		defaultDialog=getScreens().informationErrorDialog("Empty");
    	}
    	else{
        authorizationRestServiceClient.login(username.getText(), password.getText());

       // Optional.ofNullable(app.getSession()) -> defaultDialog=getScreens().informationErrorDialog("Register"););

        if(app.getSession()==null){
        	defaultDialog=getScreens().informationErrorDialog("Login");
        }else{
        
        if(app.getSession().getUserType().equals("admin"))
        		defaultDialog = getScreens().artifactListAdminDialog();
        else
        if(app.getSession().getUserType().equals("user"))
        		defaultDialog = getScreens().artifactListDialog();
        else
        	throw new LoginException();
        }
    	}
        getDialog().close();
        getScreens().showDialog(defaultDialog);

    }
    @FXML
    public void register() {
        FXMLDialog defaultDialog=getScreens().registerDialog();
        getDialog().close();
        getScreens().showDialog(defaultDialog);
    }

    @Override
    public String getResourcePath() {
        return "/com/crashcourse/restclient/controller/ConfirmationDialog.fxml";
    }

}
