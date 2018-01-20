package com.crashcourse.restclient.controller;

import com.crashcourse.restclient.main.config.StoreXSecurityContext;
import com.crashcourse.restclient.model.PozycjaZamowieniaModel;
import com.crashcourse.restclient.model.UmieszczenieModel;
import com.crashcourse.restclient.model.ZamowienieZakupuModel;
import com.crashcourse.restclient.view.FXMLDialog;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * klasa odpowiadająca za kontroler dialogu po wybraniu złej ilości produktu
 */
public class OKWrongQuantityController extends ArtifactsBaseController {

    @Autowired
    private StoreXSecurityContext context;

    private ZamowienieZakupuModel zamowienieZakupu;
    private PozycjaZamowieniaModel pozycjaZamowienia;
    private UmieszczenieModel umieszczenie;
    private String message;

    @FXML
    private Label label;

    public OKWrongQuantityController(Stage primaryStage, ZamowienieZakupuModel zamowienieZakupu, PozycjaZamowieniaModel pozycjaZamowienia, UmieszczenieModel umieszczenie, String message) {
        super(primaryStage);
        this.zamowienieZakupu=zamowienieZakupu;
        this.pozycjaZamowienia=pozycjaZamowienia;
        this.umieszczenie=umieszczenie;
        this.message= message;
    }

    @FXML
    public void initialize() {
        if (message != null)
            label.setText(message);
    }
    @FXML
    public void close() {
        getDialog().close();
    }

    @Override
    public String getResourcePath() {
        return "/com/crashcourse/restclient/controller/OKWrongQuantity.fxml";
    }


    /**
     * powrót do wyboru ilości produktu. przycisk OK
     */
    @FXML
    public void proceed() {
        FXMLDialog defaultDialog=getScreens().quantityProductDialog(zamowienieZakupu,pozycjaZamowienia,umieszczenie);
        getDialog().close();
        getScreens().showDialog(defaultDialog);
    }
}
