package com.crashcourse.restclient.controller;

import com.crashcourse.restclient.api.PozycjaZamowieniaRestServiceClient;
import com.crashcourse.restclient.api.UmieszczenieRestServiceClient;
import com.crashcourse.restclient.api.ZamowienieZakupuRestServiceClient;
import com.crashcourse.restclient.datatype.PozycjaZamowieniaTO;
import com.crashcourse.restclient.datatype.enumeration.TypOdbioru;
import com.crashcourse.restclient.main.config.StoreXSecurityContext;
import com.crashcourse.restclient.model.PozycjaZamowieniaModel;
import com.crashcourse.restclient.model.ZamowienieZakupuModel;
import com.crashcourse.restclient.view.AlertDialog;
import com.crashcourse.restclient.view.FXMLDialog;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * klasa kontrolera odpowiadającego za dialog z listą produktów w zamówieniu
 */
public class ProductPickupController extends ArtifactsBaseController {

    @Autowired
    private StoreXSecurityContext context;
    @Autowired
    private PozycjaZamowieniaRestServiceClient pozycjaZamowieniaRestServiceClient;
    @Autowired
    private ZamowienieZakupuRestServiceClient zamowienieZakupuRestServiceClient;
    @Autowired
    private UmieszczenieRestServiceClient umieszczenieRestServiceClient;

    private ZamowienieZakupuModel zamowienieZakupu;

    @FXML
    private Label pickUpLabel;
    @FXML
    private TableView<PozycjaZamowieniaModel> productsTable;
    @FXML
    TableColumn<PozycjaZamowieniaModel, String> codeColumn;
    @FXML
    TableColumn<PozycjaZamowieniaModel, String> nameColumn;
    @FXML
    TableColumn<PozycjaZamowieniaModel, Double> quantityColumn;
    @FXML
    TableColumn<PozycjaZamowieniaModel, Double> realizedColumn;

    public ProductPickupController(Stage primaryStage, ZamowienieZakupuModel zamowienieZakupu) {
        super(primaryStage);
        this.zamowienieZakupu = zamowienieZakupu;
    }

    /**
     * metoda inicjująca dane w dialogu
     */
    @FXML
    public void initialize() {
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        pickUpLabel.setText("Zamówienie: " + zamowienieZakupu.getKod().get() + " Termin realizacji: " + df.format(zamowienieZakupu.getTerminRealizacji().get()));
        loadAllData();
        codeColumn.setCellValueFactory(celldata -> celldata.getValue().getTowar().get().getKod());
        nameColumn.setCellValueFactory(celldata -> new SimpleStringProperty(celldata.getValue().getTowar().get().getNazwa().get()
                + " (" + celldata.getValue().getTowar().get().getJednostka().get().getRodzaj().get() + ")"));
        quantityColumn.setCellValueFactory(celldata -> celldata.getValue().getIlosc().asObject());
        realizedColumn.setCellValueFactory(celldata -> celldata.getValue().getZrealizowano().asObject());
    }

    /**
     * metoda pobierająca dane z severa i ustawiająca je do tabeli
     */
    private void loadAllData() {
        List<PozycjaZamowieniaTO> pozycje = pozycjaZamowieniaRestServiceClient.getPozycjeZamowienia(zamowienieZakupu.getID());
        List<PozycjaZamowieniaModel> rows = pozycje.stream().map(PozycjaZamowieniaModel::fromPozycjaZamowieniaTo).collect(Collectors.toList());
        productsTable.setItems(FXCollections.observableArrayList(rows));
    }

    @FXML
    public void close() {
        getDialog().close();
    }

    @Override
    public String getResourcePath() {
        return "/com/crashcourse/restclient/controller/ProductPickup.fxml";
    }

    /**
     * metoda do powrotu do dialogu z listą zamówień
     * przycisk anuluj
     */
    @FXML
    public void backToOrderPickup() {
        FXMLDialog defaultDialog = getScreens().orderPickupDialog();
        getDialog().close();
        getScreens().showDialog(defaultDialog);
    }

    /**
     * metoda służąca do wydania zamówienia co skutkuje zmianą jego statusu
     * przycisk wydawana
     */
    @FXML
    public void issue() {
        AlertDialog alertDialog = new AlertDialog();
        Alert alert = alertDialog.getConfirmationAlert();
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get().equals(alertDialog.getButtonOK())) {
            zamowienieZakupuRestServiceClient.updateStatusZamowienieZakupu(zamowienieZakupu.getID());
            FXMLDialog defaultDialog;
            if(zamowienieZakupu.getTypOdbioru().get()== TypOdbioru.Osobiscie) {
                defaultDialog = getScreens().shipmentDataDialog(zamowienieZakupu);
            }
            else{
                defaultDialog = getScreens().okEmailDialog();
            }
            getDialog().close();
            getScreens().showDialog(defaultDialog);
        }
    }

    /**
     * metoda przejścia do dialogu z wyborem lokalizacji produktu
     * przycisk OK
     */
    @FXML
    public void proceed() {
        FXMLDialog defaultDialog;

        if (productsTable.getSelectionModel().getSelectedItem() != null) {

            PozycjaZamowieniaModel pozycjaZamowienia = productsTable.getSelectionModel().getSelectedItem();
            if(umieszczenieRestServiceClient.getUmieszczenieTowaru(pozycjaZamowienia.getTowar().get().getID()).size()!=0) {

                defaultDialog = getScreens().localizationPickupDialog(zamowienieZakupu, pozycjaZamowienia);

            }
            else{

                defaultDialog = getScreens().okOutOFProductDialog(zamowienieZakupu);

            }
            getDialog().close();
            getScreens().showDialog(defaultDialog);
        }
    }
}
