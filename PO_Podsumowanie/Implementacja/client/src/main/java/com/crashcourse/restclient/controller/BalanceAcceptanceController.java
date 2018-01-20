package com.crashcourse.restclient.controller;

import com.crashcourse.restclient.main.config.StoreXSecurityContext;
import com.crashcourse.restclient.view.FXMLDialog;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * kontroler odpowiadający za akceptację bilansu
 */
public class BalanceAcceptanceController extends ArtifactsBaseController {

    @Autowired
    private StoreXSecurityContext context;

    public BalanceAcceptanceController(Stage primaryStage) {
        super(primaryStage);
    }

    @FXML
    public void close() {
        getDialog().close();
    }

    @Override
    public String getResourcePath() {
        return "/com/crashcourse/restclient/controller/BalanceAcceptance.fxml";
    }

    /**
     * metoda zmiany ekranu na głowny. przycisk OK
     */
    @FXML
    public void goToMainScreen() {
        FXMLDialog defaultDialog = getScreens().mainScreenDialog();
        getDialog().close();
        getScreens().showDialog(defaultDialog);
    }
}
