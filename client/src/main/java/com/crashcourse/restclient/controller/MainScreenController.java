package com.crashcourse.restclient.controller;

import com.crashcourse.restclient.api.ArtifactRestServiceClient;
import com.crashcourse.restclient.datatype.enumeration.ArtifactTo;
import com.crashcourse.restclient.datatype.enumeration.Category;
import com.crashcourse.restclient.datatype.enumeration.Status;
import com.crashcourse.restclient.main.config.StoreXSecurityContext;
import com.crashcourse.restclient.model.ArtifactModel;
import com.crashcourse.restclient.view.FXMLDialog;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.text.html.ImageView;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class MainScreenController extends ArtifactsBaseController {

    @Autowired
    private ArtifactRestServiceClient restServiceClient;
    @Autowired
    private StoreXSecurityContext context;

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

    @FXML
    public void logOut() {
        context.deleteSession();
        FXMLDialog defaultDialog = getScreens().loginDialog();
        getDialog().close();
        getScreens().showDialog(defaultDialog);
    }

    @FXML
    public void makeBalance() {
        FXMLDialog defaultDialog = getScreens().monthPickupDialog();
        getDialog().close();
        getScreens().showDialog(defaultDialog);
    }
    @FXML
    public void completeOrder() {
        FXMLDialog defaultDialog = getScreens().orderPickupDialog();
        getDialog().close();
        getScreens().showDialog(defaultDialog);
    }
}
