package com.crashcourse.restclient.controller;

import com.crashcourse.restclient.api.AuthorizationRestServiceClient;
import com.crashcourse.restclient.main.config.StoreXSecurityContext;
import com.crashcourse.restclient.view.FXMLDialog;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.security.auth.login.LoginException;

public class LoginController extends ArtifactsBaseController {

    @Autowired
    StoreXSecurityContext app;

    @Qualifier("authorizationRestServiceClientImpl")
    @Autowired
    private AuthorizationRestServiceClient authorizationRestServiceClient;

    @FXML
    PasswordField password;
    @FXML
    TextField username;

    public LoginController(Stage primaryStage) {
        super(primaryStage);
    }

    @FXML
    public void proceed() throws LoginException {

        FXMLDialog defaultDialog = null;
        if (username.getText().equals("") || password.getText().equals("")) {
            defaultDialog = getScreens().informationErrorDialog("Empty");
        } else {
            authorizationRestServiceClient.login(username.getText(), password.getText());

            // Optional.ofNullable(app.getSession()) -> defaultDialog=getScreens().informationErrorDialog("Register"););

            if (app.getSession() == null) {
                defaultDialog = getScreens().informationErrorDialog("Login");
            } else {

                if (app.getSession().getUserType().equals("admin"))
                    defaultDialog = getScreens().mainScreenDialog();
                else if (app.getSession().getUserType().equals("user"))
                    defaultDialog = getScreens().mainScreenDialog();
                else
                    throw new LoginException();
            }
        }
        getDialog().close();
        getScreens().showDialog(defaultDialog);

    }

    @Override
    public String getResourcePath() {
        return "/com/crashcourse/restclient/controller/Login.fxml";
    }

}
