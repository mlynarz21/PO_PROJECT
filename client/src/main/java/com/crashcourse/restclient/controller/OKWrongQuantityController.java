package com.crashcourse.restclient.controller;

import com.crashcourse.restclient.api.ArtifactRestServiceClient;
import com.crashcourse.restclient.main.config.StoreXSecurityContext;
import com.crashcourse.restclient.model.PozycjaZamowieniaModel;
import com.crashcourse.restclient.model.UmieszczenieModel;
import com.crashcourse.restclient.model.ZamowienieZakupuModel;
import com.crashcourse.restclient.view.FXMLDialog;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;

public class OKWrongQuantityController extends ArtifactsBaseController {

    @Autowired
    private StoreXSecurityContext context;

    private ZamowienieZakupuModel zamowienieZakupu;
    private PozycjaZamowieniaModel pozycjaZamowienia;
    private UmieszczenieModel umieszczenie;

    public OKWrongQuantityController(Stage primaryStage, ZamowienieZakupuModel zamowienieZakupu, PozycjaZamowieniaModel pozycjaZamowienia, UmieszczenieModel umieszczenie) {
        super(primaryStage);
        this.zamowienieZakupu=zamowienieZakupu;
        this.pozycjaZamowienia=pozycjaZamowienia;
        this.umieszczenie=umieszczenie;
    }

    @FXML
    public void close() {
        getDialog().close();
    }

    @Override
    public String getResourcePath() {
        return "/com/crashcourse/restclient/controller/OKWrongQuantity.fxml";
    }

    @FXML
    public void proceed() {
        FXMLDialog defaultDialog=getScreens().quantityProductDialog(zamowienieZakupu,pozycjaZamowienia,umieszczenie);
        getDialog().close();
        getScreens().showDialog(defaultDialog);
    }
}
