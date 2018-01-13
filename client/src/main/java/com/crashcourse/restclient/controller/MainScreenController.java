package com.crashcourse.restclient.controller;

import com.crashcourse.restclient.api.ZamowienieZakupuRestServiceClient;
import com.crashcourse.restclient.main.config.StoreXSecurityContext;
import com.crashcourse.restclient.view.FXMLDialog;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * kontroler odpowiadający za głowny ekran aplikacji
 */
public class MainScreenController extends ArtifactsBaseController {

    @Autowired
    private StoreXSecurityContext context;
    @Autowired
    private ZamowienieZakupuRestServiceClient zamowienieZakupuRestServiceClient;

    public MainScreenController(Stage primaryStage) {
        super(primaryStage);
    }

    @FXML
    public void close() {
        getDialog().close();
    }

    @Override
    public String getResourcePath() {
        return "/com/crashcourse/restclient/controller/MainScreen.fxml";
    }

    /**
     * metoda wylogowująca użytkownika
     * przycisk w GUI
     */
    @FXML
    public void logOut() {
        context.deleteSession();
        FXMLDialog defaultDialog = getScreens().loginDialog();
        getDialog().close();
        getScreens().showDialog(defaultDialog);
    }

    /**
     * metoda rozpoczynająca tworzenie nowego bilansu
     * przycisk w GUI
     */
    @FXML
    public void makeBalance() {
        FXMLDialog defaultDialog = getScreens().monthPickupDialog();
        getDialog().close();
        getScreens().showDialog(defaultDialog);
    }

    /**
     * metoda rozpoczynająca kompletowanie zamówienia
     * przycisk w GUI
     */
    @FXML
    public void completeOrder() {
        FXMLDialog defaultDialog;

        if(zamowienieZakupuRestServiceClient.getAllZaakceptowane().size()!=0) {
            defaultDialog = getScreens().orderPickupDialog();
        }
        else{
            defaultDialog = getScreens().okNoWaitingOrdersDialog();
        }
        getDialog().close();
        getScreens().showDialog(defaultDialog);
    }
}
