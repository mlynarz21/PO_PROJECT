package com.crashcourse.restclient.controller;

import com.crashcourse.restclient.api.ArtifactRestServiceClient;
import com.crashcourse.restclient.main.config.StoreXSecurityContext;
import com.crashcourse.restclient.view.FXMLDialog;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.text.html.ImageView;

public class OrderPickupController extends ArtifactsBaseController {

    @Autowired
    private ArtifactRestServiceClient restServiceClient;
    @Autowired
    private StoreXSecurityContext context;

    public OrderPickupController(Stage primaryStage) {
        super(primaryStage);
    }

    @FXML
    public void close() {
        getDialog().close();
    }

    @Override
    public String getResourcePath() {
        return "/com/crashcourse/restclient/controller/OrderPickup.fxml";
    }

    @FXML
    public void back() {
        FXMLDialog defaultDialog=getScreens().mainScreenDialog();
        getDialog().close();
        getScreens().showDialog(defaultDialog);
    }

    @FXML
    public void proceed() {
        FXMLDialog defaultDialog=getScreens().productPickupDialog();
        getDialog().close();
        getScreens().showDialog(defaultDialog);
    }

}
