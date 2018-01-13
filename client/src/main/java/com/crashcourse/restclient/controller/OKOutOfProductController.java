package com.crashcourse.restclient.controller;

import com.crashcourse.restclient.main.config.StoreXSecurityContext;
import com.crashcourse.restclient.model.ZamowienieZakupuModel;
import com.crashcourse.restclient.view.FXMLDialog;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * klasa odpowiadająca za dialog informujący o braku danego prodtu na magazynie
 */
public class OKOutOfProductController extends ArtifactsBaseController {

    @Autowired
    private StoreXSecurityContext context;

    private ZamowienieZakupuModel zamowienieZakupu;

    public OKOutOfProductController(Stage primaryStage,ZamowienieZakupuModel zamowienieZakupu) {
        super(primaryStage);
        this.zamowienieZakupu=zamowienieZakupu;
    }

    @FXML
    public void close() {
        getDialog().close();
    }

    @Override
    public String getResourcePath() {
        return "/com/crashcourse/restclient/controller/OKOutOfProduct.fxml";
    }

    /**
     * metoda powracająca do ekranu z listą produktów, przycik OK
     */
    @FXML
    public void proceed() {
        FXMLDialog defaultDialog=getScreens().productPickupDialog(zamowienieZakupu);
        getDialog().close();
        getScreens().showDialog(defaultDialog);
    }
}
