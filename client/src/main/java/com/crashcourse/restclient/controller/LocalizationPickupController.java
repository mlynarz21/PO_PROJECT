package com.crashcourse.restclient.controller;

import com.crashcourse.restclient.api.UmieszczenieRestServiceClient;
import com.crashcourse.restclient.datatype.UmieszczenieTO;
import com.crashcourse.restclient.main.config.StoreXSecurityContext;
import com.crashcourse.restclient.model.PozycjaZamowieniaModel;
import com.crashcourse.restclient.model.UmieszczenieModel;
import com.crashcourse.restclient.model.ZamowienieZakupuModel;
import com.crashcourse.restclient.view.FXMLDialog;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

/**
 * kontroler odpowiadający za wyświetlanie lokalizacji produktu
 */
public class LocalizationPickupController extends ArtifactsBaseController {

    @Autowired
    private StoreXSecurityContext context;
    @Autowired
    private UmieszczenieRestServiceClient umieszczenieRestServiceClient;

    private ZamowienieZakupuModel zamowienieZakupu;
    private PozycjaZamowieniaModel pozycjaZamowienia;

    @FXML
    private Label localizationLabel;
    @FXML
    private TableView<UmieszczenieModel> localizationTable;
    @FXML
    TableColumn<UmieszczenieModel, String> codeColumn;
    @FXML
    TableColumn<UmieszczenieModel, Double> quantityColumn;

    public LocalizationPickupController(Stage primaryStage, ZamowienieZakupuModel zamowienieZakupu, PozycjaZamowieniaModel pozycjaZamowienia) {
        super(primaryStage);
        this.zamowienieZakupu = zamowienieZakupu;
        this.pozycjaZamowienia = pozycjaZamowienia;
    }

    /**
     * metoda inicująca dane do wyświetlenia
     */
    @FXML
    public void initialize() {
        loadAllData();
        localizationLabel.setText("Towar: "
                + pozycjaZamowienia.getTowar().get().getKod().get()
                + " Nazwa: "
                + pozycjaZamowienia.getTowar().get().getNazwa().get()
                + " Potrzeba jeszcze: "
                + (pozycjaZamowienia.getIlosc().get() - pozycjaZamowienia.getZrealizowano().get()));

        codeColumn.setCellValueFactory(celldata -> celldata.getValue().getLokalizacja().get().getKod());
        quantityColumn.setCellValueFactory(celldata -> celldata.getValue().getIloscWLokalizacji().asObject());
    }

    /**
     * metoda ustawiająca pobierająca dane z servera i ustawająca je do tabeli
     */
    private void loadAllData() {
        List<UmieszczenieTO> umieszczenia = umieszczenieRestServiceClient.getUmieszczenieTowaru(pozycjaZamowienia.getTowar().get().getID());
        List<UmieszczenieModel> rows = umieszczenia.stream().map(UmieszczenieModel::fromUmieszenieTo).collect(Collectors.toList());
        localizationTable.setItems(FXCollections.observableArrayList(rows));
    }

    @FXML
    public void close() {
        getDialog().close();
    }

    @Override
    public String getResourcePath() {
        return "/com/crashcourse/restclient/controller/LocalizationPickup.fxml";
    }

    /**
     * metoda powrotu do dialogu z produktami w zamówieniu. przycisk Anuluj
     */
    @FXML
    public void back() {
        FXMLDialog defaultDialog=getScreens().productPickupDialog(zamowienieZakupu);
        getDialog().close();
        getScreens().showDialog(defaultDialog);
    }

    /**
     * metoda do wyświetlenia dialogu z pobieraniem ilości z lokalizacji, przycisk OK
     */
    @FXML
    public void proceed() {
        FXMLDialog defaultDialog;
        if (localizationTable.getSelectionModel().getSelectedItem() != null) {
            UmieszczenieModel umieszczenie = localizationTable.getSelectionModel().getSelectedItem();
            defaultDialog = getScreens().quantityProductDialog(zamowienieZakupu, pozycjaZamowienia, umieszczenie);
            getDialog().close();
            getScreens().showDialog(defaultDialog);
        }
    }

}
