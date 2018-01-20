package com.crashcourse.restclient.controller;

import com.crashcourse.restclient.main.config.StoreXSecurityContext;
import com.crashcourse.restclient.view.FXMLDialog;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * klasa odpowiadająca za kontroler dialogu który informuje o niepoprawnie wybranej dacie bilansowania
 */
public class OKWrongDateController extends ArtifactsBaseController {

    @Autowired
    private StoreXSecurityContext context;

    public OKWrongDateController(Stage primaryStage) {
        super(primaryStage);
    }

    @FXML
    public void close() {
        getDialog().close();
    }

    @Override
    public String getResourcePath() {
        return "/com/crashcourse/restclient/controller/OKWrongDate.fxml";
    }

    /**
     * metoda odpowiadająca za przejście do dialogu z wyborem miesiąca bilansowania, przycisk OK
     */
    @FXML
    public void proceed() {
        FXMLDialog defaultDialog=getScreens().monthPickupDialog();
        getDialog().close();
        getScreens().showDialog(defaultDialog);
    }
}
