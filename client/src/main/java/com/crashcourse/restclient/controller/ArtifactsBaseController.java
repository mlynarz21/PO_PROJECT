package com.crashcourse.restclient.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.crashcourse.restclient.controller.basic.DialogController;
import com.crashcourse.restclient.controller.basic.ScreensConfiguration;
import com.crashcourse.restclient.view.FXMLDialog;

import javafx.stage.Stage;

public abstract class ArtifactsBaseController implements DialogController {

    private FXMLDialog dialog;

    private Stage primaryStage;
    @Autowired
    private ScreensConfiguration screens;

    public ArtifactsBaseController(Stage primaryStage) {
        super();
        this.primaryStage = primaryStage;
    }

    protected FXMLDialog getDialog() {

        return dialog;
    }

    @Override
    public void setDialog(FXMLDialog dialog) {
        this.dialog = dialog;
    }

    @Override
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    protected ScreensConfiguration getScreens() {
        return screens;
    }

}