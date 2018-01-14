package com.crashcourse.restclient.controller;

import com.crashcourse.restclient.api.PozycjaZamowieniaRestServiceClient;
import com.crashcourse.restclient.api.UmieszczenieRestServiceClient;
import com.crashcourse.restclient.main.config.StoreXSecurityContext;
import com.crashcourse.restclient.model.PozycjaZamowieniaModel;
import com.crashcourse.restclient.model.UmieszczenieModel;
import com.crashcourse.restclient.model.ZamowienieZakupuModel;
import com.crashcourse.restclient.view.FXMLDialog;
import javafx.beans.property.DoubleProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.regex.Pattern;

/**
 * klasa kontrolera odpowiadającego za ekran wyboru ilości pobranego towaru
 */
public class QuantityProductController extends ArtifactsBaseController {

    @Autowired
    private StoreXSecurityContext context;
    @Autowired
    private PozycjaZamowieniaRestServiceClient pozycjaZamowieniaRestServiceClient;

    private ZamowienieZakupuModel zamowienieZakupu;
    private PozycjaZamowieniaModel pozycjaZamowienia;
    private UmieszczenieModel umieszczenie;
    private static String MSG_QUANTITY_OVERFLOW = "Podano za dużą liczbę";
    private static String MSG_QUANTITY_LESS_THAN_ZERO = "Podano za małą liczbę";

    @FXML
    private Label quantityLabel;
    @FXML
    private TextField quantityTextField;

    @Autowired
    private UmieszczenieRestServiceClient umieszczenieRestServiceClient;

    public QuantityProductController(Stage primaryStage, ZamowienieZakupuModel zamowienieZakupu, PozycjaZamowieniaModel pozycjaZamowienia, UmieszczenieModel umieszczenie) {
        super(primaryStage);
        this.zamowienieZakupu=zamowienieZakupu;
        this.pozycjaZamowienia=pozycjaZamowienia;
        this.umieszczenie=umieszczenie;
    }

    /**
     * metoda inicjacji dialogu (label)
     */
    @FXML
    public void initialize() {
        quantityLabel.setText("Towar: "
                + pozycjaZamowienia.getTowar().get().getKod().get()
                + " Nazwa: "
                + pozycjaZamowienia.getTowar().get().getNazwa().get()
                + " Potrzeba jeszcze: "
                + (pozycjaZamowienia.getIlosc().get() - pozycjaZamowienia.getZrealizowano().get()));
    }


    @FXML
    public void close() {
        getDialog().close();
    }

    @Override
    public String getResourcePath() {
        return "/com/crashcourse/restclient/controller/QuantityProduct.fxml";
    }

    /**
     * metoda powrotu do dialogu z lokalizacjami towaru, przycisk anuluj
     */
    @FXML
    public void back() {
        FXMLDialog defaultDialog=getScreens().localizationPickupDialog(zamowienieZakupu,pozycjaZamowienia);
        getDialog().close();
        getScreens().showDialog(defaultDialog);
    }

    /**
     * metoda do akceptacji ilości zmienionego towaru. przycisk OK
     */
    @FXML
    public void proceed() {
        FXMLDialog defaultDialog;
        DecimalFormat decimalFormat = new DecimalFormat("#");
        try {
            if (!Pattern.matches("[0-9.,\\-]+", quantityTextField.getText()))
                throw new ParseException("Not a number", 0);
            double number = Double.parseDouble(quantityTextField.getText().replace(",", "."));
            if (number <= umieszczenie.getIloscWLokalizacji().get() && number <= pozycjaZamowienia.getIlosc().get() - pozycjaZamowienia.getZrealizowano().get() && number > 0) {
                pozycjaZamowieniaRestServiceClient.proceedPozycjaZamowienia(pozycjaZamowienia.getID(), umieszczenie.getID(), number);
                defaultDialog = getScreens().productPickupDialog(zamowienieZakupu);
            } else if (number<=0) {
                defaultDialog = getScreens().okWrongQuantityDialog(zamowienieZakupu, pozycjaZamowienia, umieszczenie, MSG_QUANTITY_LESS_THAN_ZERO);
            } else {
                defaultDialog = getScreens().okWrongQuantityDialog(zamowienieZakupu, pozycjaZamowienia, umieszczenie, MSG_QUANTITY_OVERFLOW);
            }
            getDialog().close();
            getScreens().showDialog(defaultDialog);

        } catch (ParseException e) {
            defaultDialog = getScreens().okWrongQuantityDialog(zamowienieZakupu, pozycjaZamowienia, umieszczenie, null);
            getDialog().close();
            getScreens().showDialog(defaultDialog);
        }
    }

}
