package com.crashcourse.restclient.controller;

import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class DefaultDialogController extends ArtifactsBaseController {
    public DefaultDialogController(Stage primaryStage) {
        super(primaryStage);
    }

    @FXML
    public void close() {
        getDialog().hide();
        getDialog().getOnCloseRequest().handle(new WindowEvent(getDialog(), WindowEvent.WINDOW_CLOSE_REQUEST));
        getDialog().close();
    }

    @Override
    public String getResourcePath() {
        return "/com/crashcourse/restclient/controller/Default.fxml";
    }

}
