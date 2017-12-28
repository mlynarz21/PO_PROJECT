package com.crashcourse.restclient.controller;

import com.crashcourse.restclient.main.config.StoreXSecurityContext;
import com.crashcourse.restclient.model.PozycjaZamowieniaModel;
import com.crashcourse.restclient.model.UmieszczenieModel;
import com.crashcourse.restclient.model.ZamowienieZakupuModel;
import com.crashcourse.restclient.view.FXMLDialog;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.DecimalFormat;
import java.text.ParseException;

public class QuantityProductController extends ArtifactsBaseController {

    @Autowired
    private StoreXSecurityContext context;

    private ZamowienieZakupuModel zamowienieZakupu;
    private PozycjaZamowieniaModel pozycjaZamowienia;
    private UmieszczenieModel umieszczenie;

    @FXML
    private Label localizationLabel;
    @FXML
    private TextField quantityTextField;

    public QuantityProductController(Stage primaryStage, ZamowienieZakupuModel zamowienieZakupu, PozycjaZamowieniaModel pozycjaZamowienia, UmieszczenieModel umieszczenie) {
        super(primaryStage);
        this.zamowienieZakupu=zamowienieZakupu;
        this.pozycjaZamowienia=pozycjaZamowienia;
        this.umieszczenie=umieszczenie;
    }

    @FXML
    public void initialize() {
        localizationLabel.setText(localizationLabel.getText() + umieszczenie.getLokalizacja().get().getKod().get());
    }


    @FXML
    public void close() {
        getDialog().close();
    }

    @Override
    public String getResourcePath() {
        return "/com/crashcourse/restclient/controller/QuantityProduct.fxml";
    }

    @FXML
    public void back() {
        FXMLDialog defaultDialog=getScreens().localizationPickupDialog(zamowienieZakupu,pozycjaZamowienia);
        getDialog().close();
        getScreens().showDialog(defaultDialog);
    }

    @FXML
    public void proceed() {
        FXMLDialog defaultDialog;
        DecimalFormat decimalFormat = new DecimalFormat("#");
        try {
            double number = decimalFormat.parse(quantityTextField.getText()).doubleValue();
            if(number <= umieszczenie.getIloscWLokalizacji().get() && number<=pozycjaZamowienia.getIlosc().get()-pozycjaZamowienia.getZrealizowano().get()){
                defaultDialog=getScreens().productPickupDialog(zamowienieZakupu);
            }
            else {
                defaultDialog=getScreens().okWrongQuantityDialog(zamowienieZakupu, pozycjaZamowienia, umieszczenie);
            }
            getDialog().close();
            getScreens().showDialog(defaultDialog);
        } catch (ParseException e) {
            defaultDialog=getScreens().okWrongQuantityDialog(zamowienieZakupu, pozycjaZamowienia, umieszczenie);
            getDialog().close();
            getScreens().showDialog(defaultDialog);
        }
    }

}
