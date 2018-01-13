package com.crashcourse.restclient.controller;

import com.crashcourse.restclient.main.config.StoreXSecurityContext;
import com.crashcourse.restclient.view.FXMLDialog;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * klasa obsługująca za kontroler dialogu wyświetlającego informację o braku aktualnie oczekujących zamówień
 */
public class OKNoWaitingOrdersController extends ArtifactsBaseController {

    @Autowired
    private StoreXSecurityContext context;

    public OKNoWaitingOrdersController(Stage primaryStage) {
        super(primaryStage);
    }

    @FXML
    public void close() {
        getDialog().close();
    }

    @Override
    public String getResourcePath() {
        return "/com/crashcourse/restclient/controller/OKNoWaitingOrders.fxml";
    }

    /**
     * metoda powracająca do głownego ektanu. przycisk OK
     */
    @FXML
    public void proceed() {
        FXMLDialog defaultDialog=getScreens().mainScreenDialog();
        getDialog().close();
        getScreens().showDialog(defaultDialog);
    }
}
