package com.crashcourse.restclient.controller;

import com.crashcourse.restclient.main.config.StoreXSecurityContext;
import com.crashcourse.restclient.model.ZamowienieZakupuModel;
import com.crashcourse.restclient.view.FXMLDialog;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * klasa kontrolera odpowiedzialnego za dialog z danymi do adresowania zamówienia
 */
public class ShipmentDataController extends ArtifactsBaseController {

    @Autowired
    private StoreXSecurityContext context;

    private ZamowienieZakupuModel zamowienieZakupu;

    @FXML
    private Label nameLabel;
    @FXML
    private Label surnameLabel;
    @FXML
    private Label streetLabel;
    @FXML
    private Label postalCodeLabel;

    public ShipmentDataController(Stage primaryStage,ZamowienieZakupuModel zamowienieZakupu) {
        super(primaryStage);
        this.zamowienieZakupu=zamowienieZakupu;
    }

    /**
     * inicjalizacja danych w kontrolerze
     */
    @FXML
    public void initialize() {
        nameLabel.setText(zamowienieZakupu.getKlient().get().getImie().get());
        surnameLabel.setText(zamowienieZakupu.getKlient().get().getNazwisko().get());
        streetLabel.setText(zamowienieZakupu.getKlient().get().getUlica().get() + " " +zamowienieZakupu.getKlient().get().getNumerDomu().get());
        postalCodeLabel.setText(zamowienieZakupu.getKlient().get().getKodPocztowy().get() + " " + zamowienieZakupu.getKlient().get().getMiasto().get());
    }

    @FXML
    public void close() {
        getDialog().close();
    }

    @Override
    public String getResourcePath() {
        return "/com/crashcourse/restclient/controller/ShipmentData.fxml";
    }

    /**
     * przejście do głownego ekranu
     * przycisk OK
     */
    @FXML
    public void proceed() {
        FXMLDialog defaultDialog=getScreens().mainScreenDialog();
        getDialog().close();
        getScreens().showDialog(defaultDialog);
    }

}
