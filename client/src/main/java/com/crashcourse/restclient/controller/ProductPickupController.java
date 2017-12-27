package com.crashcourse.restclient.controller;

import com.crashcourse.restclient.api.ArtifactRestServiceClient;
import com.crashcourse.restclient.api.PozycjaZamowieniaRestServiceClient;
import com.crashcourse.restclient.api.ZamowienieZakupuRestServiceClient;
import com.crashcourse.restclient.datatype.PozycjaZamowieniaTO;
import com.crashcourse.restclient.main.config.StoreXSecurityContext;
import com.crashcourse.restclient.model.PozycjaZamowieniaModel;
import com.crashcourse.restclient.model.ZamowienieZakupuModel;
import com.crashcourse.restclient.view.AlertDialog;
import com.crashcourse.restclient.view.FXMLDialog;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProductPickupController extends ArtifactsBaseController {

    @Autowired
    private StoreXSecurityContext context;
    @Autowired
    private PozycjaZamowieniaRestServiceClient pozycjaZamowieniaRestServiceClient;
    @Autowired
    private ZamowienieZakupuRestServiceClient zamowienieZakupuRestServiceClient;

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

    @FXML
    public void initialize() {
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        pickUpLabel.setText("Zamówienie: " + zamowienieZakupu.getKod().get() + " Termin realizacji: " + df.format(zamowienieZakupu.getTerminRealizacji().get()));
        loadAllData();
        codeColumn.setCellValueFactory(celldata -> celldata.getValue().getTowar().get().getKod());
        nameColumn.setCellValueFactory(celldata -> celldata.getValue().getTowar().get().getNazwa());
        quantityColumn.setCellValueFactory(celldata -> celldata.getValue().getIlosc().asObject());
        realizedColumn.setCellValueFactory(celldata -> celldata.getValue().getZrealizowano().asObject());
    }

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

    @FXML
    public void backToOrderPickup() {
        FXMLDialog defaultDialog = getScreens().orderPickupDialog();
        getDialog().close();
        getScreens().showDialog(defaultDialog);
    }

    @FXML
    public void issue() {
        AlertDialog alertDialog = new AlertDialog();
        Alert alert = alertDialog.getConfirmationAlert();
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get().equals(alertDialog.getButtonOK())) {
            zamowienieZakupuRestServiceClient.updateStatusZamowienieZakupu(zamowienieZakupu.getID());
            FXMLDialog defaultDialog = getScreens().shipmentDataDialog();
            getDialog().close();
            getScreens().showDialog(defaultDialog);
        }
    }

    @FXML
    public void proceed() {
        if (productsTable.getSelectionModel().getSelectedItem() != null) {
            PozycjaZamowieniaModel pozycjaZamowienia = productsTable.getSelectionModel().getSelectedItem();
            FXMLDialog defaultDialog = getScreens().localizationPickupDialog(zamowienieZakupu, pozycjaZamowienia);
            getDialog().close();
            getScreens().showDialog(defaultDialog);
        }
    }
}
