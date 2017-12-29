package com.crashcourse.restclient.controller;

import com.crashcourse.restclient.api.ZamowienieZakupuRestServiceClient;
import com.crashcourse.restclient.datatype.ZamowienieZakupuTO;
import com.crashcourse.restclient.main.config.StoreXSecurityContext;
import com.crashcourse.restclient.model.ZamowienieZakupuModel;
import com.crashcourse.restclient.view.FXMLDialog;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class OrderPickupController extends ArtifactsBaseController {

    @Autowired
    private StoreXSecurityContext context;
    @Autowired
    private ZamowienieZakupuRestServiceClient zamowienieZakupuRestServiceClient;
    @FXML
    private TableView<ZamowienieZakupuModel> ordersTable;
    @FXML
    TableColumn<ZamowienieZakupuModel, String> numerZamowieniaColumn;
    @FXML
    TableColumn<ZamowienieZakupuModel, String> dataZamowieniaColumn;
    @FXML
    TableColumn<ZamowienieZakupuModel, String> terminRealizacjiColumn;

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
    public void initialize() {
        loadAllData();
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        numerZamowieniaColumn.setCellValueFactory(celldata -> celldata.getValue().getKod());
        dataZamowieniaColumn.setCellValueFactory(celldata -> new SimpleStringProperty(df.format(celldata.getValue().getDataZlozenia().get())));
        terminRealizacjiColumn.setCellValueFactory(celldata -> new SimpleStringProperty(df.format(celldata.getValue().getTerminRealizacji().get())));
    }

    private void loadAllData() {
        List<ZamowienieZakupuTO> zamowienia = zamowienieZakupuRestServiceClient.getAllZaakceptowane();
        List<ZamowienieZakupuModel> rows = zamowienia.stream().map(ZamowienieZakupuModel::fromZamowienieZakupuTo).collect(Collectors.toList());
        ordersTable.setItems(FXCollections.observableArrayList(rows));
    }

    @FXML
    public void back() {
        FXMLDialog defaultDialog=getScreens().mainScreenDialog();
        getDialog().close();
        getScreens().showDialog(defaultDialog);
    }

    @FXML
    public void proceed() {

        if(ordersTable.getSelectionModel().getSelectedItem()!=null) {
            ZamowienieZakupuModel zamowienieZakupu = ordersTable.getSelectionModel().getSelectedItem();
            FXMLDialog defaultDialog = getScreens().productPickupDialog(zamowienieZakupu);
            getDialog().close();
            getScreens().showDialog(defaultDialog);
        }
    }

}
