package com.crashcourse.restclient.controller;

import com.crashcourse.restclient.api.ArtifactRestServiceClient;
import com.crashcourse.restclient.api.ZamowienieZakupuRestServiceClient;
import com.crashcourse.restclient.main.config.StoreXSecurityContext;
import com.crashcourse.restclient.model.ZamowienieZakupuModel;
import com.crashcourse.restclient.view.AlertDialog;
import com.crashcourse.restclient.view.FXMLDialog;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Optional;

public class ProductPickupController extends ArtifactsBaseController {

    @Autowired
    private StoreXSecurityContext context;
    @Autowired
    private ZamowienieZakupuRestServiceClient zamowienieZakupuRestServiceClient;

    private ZamowienieZakupuModel zamowienieZakupu;
    @FXML
    private Label pickUpLabel;

    public ProductPickupController(Stage primaryStage, ZamowienieZakupuModel zamowienieZakupu) {
        super(primaryStage);
        this.zamowienieZakupu=zamowienieZakupu;
    }

    @FXML
    public void initialize() {
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        pickUpLabel.setText("Zamówienie: " + zamowienieZakupu.getKod().get() + " Termin realizacji: " + df.format(zamowienieZakupu.getTerminRealizacji().get()));
        loadAllData();
    }

    private void loadAllData() {

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
            zamowienieZakupuRestServiceClient.updateStatusZamowienieZakupu(zamowienieZakupu.getID());
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
