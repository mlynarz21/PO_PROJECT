package com.crashcourse.restclient.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.crashcourse.restclient.controller.basic.DialogController;
import com.crashcourse.restclient.controller.basic.ScreensConfiguration;
import com.crashcourse.restclient.view.FXMLDialog;

import javafx.stage.Stage;

/**
 * klasa abstrakcyjna rozszerzana przez każdy kontroler
 */
public abstract class ArtifactsBaseController implements DialogController {

    private FXMLDialog dialog;

    private Stage primaryStage;
    @Autowired
    private ScreensConfiguration screens;

    public ArtifactsBaseController(Stage primaryStage) {
        super();
        this.primaryStage = primaryStage;
    }

    /**
     * pobiera aktualny dialog
     * @return dialog FXML
     */
    protected FXMLDialog getDialog() {
        return dialog;
    }

    /**
     * metoda do ustawiania dialogu FXML
     * @param dialog fxml dialog
     */
    @Override
    public void setDialog(FXMLDialog dialog) {
        this.dialog = dialog;
    }

    /**
     * metoda do pobrania stage
     * @return
     */
    @Override
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    /**
     * metoda dostępu do wszystkich konfiguracji ekranów w aplikacji
     * @return
     */
    protected ScreensConfiguration getScreens() {
        return screens;
    }

}