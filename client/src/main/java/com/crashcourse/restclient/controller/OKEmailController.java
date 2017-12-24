package com.crashcourse.restclient.controller;

import com.crashcourse.restclient.api.ArtifactRestServiceClient;
import com.crashcourse.restclient.main.config.StoreXSecurityContext;
import com.crashcourse.restclient.view.FXMLDialog;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;

public class OKEmailController extends ArtifactsBaseController {

    @Autowired
    private ArtifactRestServiceClient restServiceClient;
    @Autowired
    private StoreXSecurityContext context;

    public OKEmailController(Stage primaryStage) {
        super(primaryStage);
    }

    @FXML
    public void close() {
        getDialog().close();
    }

    @Override
    public String getResourcePath() {
        return "/com/crashcourse/restclient/controller/OKEmail.fxml";
    }

    @FXML
    public void proceed() {
        FXMLDialog defaultDialog=getScreens().mainScreenDialog();
        getDialog().close();
        getScreens().showDialog(defaultDialog);
    }
}
