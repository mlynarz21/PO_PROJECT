package com.crashcourse.restclient.controller.basic;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import com.crashcourse.restclient.controller.ArtifactListController;
import com.crashcourse.restclient.controller.ArtifactsBaseController;
import com.crashcourse.restclient.controller.DefaultDialogController;
import com.crashcourse.restclient.controller.WelcomeController;
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

        return manager.initializeDialog(welcomeController());
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

    public void setLocale(Locale locale) {
        this.locale = locale;

    }

    public Locale getLocale() {

        return locale;
    }

}
