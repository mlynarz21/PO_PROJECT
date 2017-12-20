package com.crashcourse.restclient.controller.basic;

import java.util.Locale;

import com.crashcourse.restclient.controller.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import com.crashcourse.restclient.view.FXMLDialog;

import javafx.stage.Stage;

@Configuration
@Lazy
public class ScreensConfiguration {

    @Autowired
    private DialogManager manager;

    private Stage primaryStage;

    private Locale locale;

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void showDialog(FXMLDialog fxmlDialog) {
        primaryStage.setScene(fxmlDialog.getScene());
        primaryStage.show();
    }

    @Bean
    @Scope("prototype")
    public FXMLDialog loginDialog() {

        return manager.initializeDialog(loginController());
    }

    @Bean
    @Scope("prototype")
    LoginController loginController() {
        return new LoginController(primaryStage);
    }

    @Bean
    @Scope("prototype")
    WelcomeController welcomeController() {
        return new WelcomeController(primaryStage);
    }

    @Bean
    @Scope("prototype")
    DefaultDialogController defaultController() {
        return new DefaultDialogController(primaryStage);
    }

    @Bean
    @Scope("prototype")
    public FXMLDialog defaultDialog() {
        return manager.initializeDialog(defaultController());
    }

    @Bean
    @Scope("prototype")
    ArtifactsBaseController artifactListController() {
        return new ArtifactListController(primaryStage);
    }

    @Bean
    @Scope("prototype")
    public FXMLDialog artifactListDialog() {
        return manager.initializeDialog(artifactListController());
    }
    
    @Bean
    @Scope("prototype")
    ArtifactsBaseController artifactListAdminController() {
        return new ArtifactListAdminController(primaryStage);
    }

    @Bean
    @Scope("prototype")
    public FXMLDialog artifactListAdminDialog() {
        return manager.initializeDialog(artifactListAdminController());
    }
       
    @Bean
    @Scope("prototype")
    ArtifactsBaseController registerController() {
        return new RegisterController(primaryStage);
    }

    @Bean
    @Scope("prototype")
    public FXMLDialog registerDialog() {
        return manager.initializeDialog(registerController());
    }




    public void setLocale(Locale locale) {
        this.locale = locale;

    }

    public Locale getLocale() {

        return locale;
    }
  
    @Bean
    @Scope("prototype")
    ArtifactsBaseController informationErrorController(String errorType) {
    	return new InformationErrorController(primaryStage, errorType);
	}
    
    @Bean
    @Scope("prototype")
	public FXMLDialog informationErrorDialog(String errorType) {
		return manager.initializeDialog(informationErrorController(errorType));
    }

    /*
    @Bean
    @Scope("prototype")
    ArtifactsBaseController informationErrorController() {
    	return new InformationErrorController(primaryStage);
	}
    
    @Bean
    @Scope("prototype")
	public FXMLDialog informationErrorDialog() {
		return manager.initializeDialog(informationErrorController());
    }
    */
	
	



}
