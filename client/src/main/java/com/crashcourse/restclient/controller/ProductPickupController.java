package com.crashcourse.restclient.controller;

import com.crashcourse.restclient.api.ArtifactRestServiceClient;
import com.crashcourse.restclient.main.config.StoreXSecurityContext;
import com.crashcourse.restclient.view.AlertDialog;
import com.crashcourse.restclient.view.FXMLDialog;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ProductPickupController extends ArtifactsBaseController {

    @Autowired
    private ArtifactRestServiceClient restServiceClient;
    @Autowired
    private StoreXSecurityContext context;

    public ProductPickupController(Stage primaryStage) {
        super(primaryStage);
    }

    @FXML
    public void close() {
        getDialog().close();
    }

    @Override
    public String getResourcePath() {
        return "/com/crashcourse/restclient/controller/ProductPickup.fxml";
    }

    @FXML
    public void backToOrderPickup() {
        FXMLDialog defaultDialog=getScreens().orderPickupDialog();
        getDialog().close();
        getScreens().showDialog(defaultDialog);
    }

    @FXML
    public void issue() {
        AlertDialog alertDialog = new AlertDialog();
        Alert alert = alertDialog.getConfirmationAlert();
        Optional<ButtonType> result = alert.showAndWait();
        if(result.get().equals(alertDialog.getButtonOK())) {
            FXMLDialog defaultDialog=getScreens().shipmentDataDialog();
            getDialog().close();
            getScreens().showDialog(defaultDialog);
        }
    }

    @FXML
    public void proceed() {
        FXMLDialog defaultDialog=getScreens().localizationPickupDialog();
        getDialog().close();
        getScreens().showDialog(defaultDialog);
    }

}
