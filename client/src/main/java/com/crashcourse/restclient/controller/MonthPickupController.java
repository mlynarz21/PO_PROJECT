package com.crashcourse.restclient.controller;

import com.crashcourse.restclient.api.BilansRestServiceClient;
import com.crashcourse.restclient.datatype.BilansTO;
import com.crashcourse.restclient.main.config.StoreXSecurityContext;
import com.crashcourse.restclient.view.FXMLDialog;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * klasa kontrolera odpowiadająca za dialog wyboru miesiąca
 */
public class MonthPickupController extends ArtifactsBaseController {

    @Autowired
    private BilansRestServiceClient bilansRestServiceClient;
    @Autowired
    private StoreXSecurityContext context;
    @FXML
    private ListView<String> datesList;

    public MonthPickupController(Stage primaryStage) {
        super(primaryStage);
    }

    /**
     * metoda inicjująca dane w dialogu i pobierająca ostatni bilans z severa
     */
    @FXML
    public void initialize() {
        BilansTO bilans = bilansRestServiceClient.getLastBilans();
        ObservableList<String> items = FXCollections.observableArrayList(getMissingBalanceDates(bilans));
        datesList.setItems(items);
    }

    /**
     * metoda towrząca listę miesiący do wyświetlenia w tabeli
     * @param bilans ostatni bilans
     * @return Lista miesięcy do wyświetlenia w tabeli
     */
    private List<String> getMissingBalanceDates(BilansTO bilans){
        List<String> toReturn= new ArrayList<>();
        Calendar currentDate = Calendar.getInstance();
        Calendar bilansDate = Calendar.getInstance();
        DateFormat df = new SimpleDateFormat("MM/yyyy");

        if(bilans==null) {
            currentDate.add(Calendar.MONTH, -1);
            toReturn.add(new StringBuilder().append(getMonth(currentDate.get(Calendar.MONTH))).append(" ").append(currentDate.get(Calendar.YEAR)).toString());
        }
        else {
            bilansDate.setTime(bilans.getDataBilansu());
            bilansDate.add(Calendar.MONTH, 1);
            while (bilansDate.get(Calendar.YEAR) != currentDate.get(Calendar.YEAR) || bilansDate.get(Calendar.MONTH) < currentDate.get(Calendar.MONTH) && bilansDate.get(Calendar.YEAR) == currentDate.get(Calendar.YEAR)) {
                toReturn.add(new StringBuilder().append(getMonth(bilansDate.get(Calendar.MONTH))).append(" ").append(bilansDate.get(Calendar.YEAR)).toString());
                bilansDate.add(Calendar.MONTH, 1);
            }
        }
        return toReturn;
    }

    /**
     * metoda odpowiadająca za konwersję miesiąca numerycznego na string
     * @param month mieiąc jako liczba
     * @return miesiąc jako string
     */
    private String getMonth(int month){
        switch (month){
            case 0:
                return "Styczeń";
            case 1:
                return "Luty";
            case 2:
                return "Marzec";
            case 3:
                return "Kwiecień";
            case 4:
                return "Maj";
            case 5:
                return "Czerwiec";
            case 6:
                return "Lipiec";
            case 7:
                return "Sierpień";
            case 8:
                return "Wrzesień";
            case 9:
                return "Październik";
            case 10:
                return "Listopad";
            case 11:
                return "Grudzień";
            default:
                return "Blad";
        }
    }

    @FXML
    public void close() {
        getDialog().close();
    }

    @Override
    public String getResourcePath() {
        return "/com/crashcourse/restclient/controller/MonthPickup.fxml";
    }

    /**
     * metoda opowiadająca za powrót do ektanu głownego, przycisk anuluj
     */
    @FXML
    public void back() {
        FXMLDialog defaultDialog = getScreens().mainScreenDialog();
        getDialog().close();
        getScreens().showDialog(defaultDialog);
    }

    /**
     * metoda do przejścia do ekranu akceptacji dialogu, przycisk OK
     */
    @FXML
    public void proceed() {
        FXMLDialog defaultDialog;

        if(datesList.getSelectionModel().getSelectedIndex()==0) {
            String selectedItem = datesList.getSelectionModel().getSelectedItem();
            String[] splited = selectedItem.split(" ");

            Calendar calendar = Calendar.getInstance();
            calendar.set(Integer.parseInt(splited[1]), fromMonthString(splited[0]),1);

            Date d = calendar.getTime();

            bilansRestServiceClient.addBilans(d);
            defaultDialog = getScreens().balanceAcceptanceDialog();
        }
        else {
            defaultDialog = getScreens().okWrongDateDialog();
        }

        getDialog().close();
        getScreens().showDialog(defaultDialog);
    }

    /**
     * metoda konwersji miesiąca ze stringa do int
     * @param month miesiąc jako string
     * @return miesiąc jako int
     */
    private int fromMonthString(String month){
        switch (month){
            case "Styczeń":
                return Calendar.JANUARY;
            case "Luty":
                return Calendar.FEBRUARY;
            case "Marzec":
                return Calendar.MARCH;
            case "Kwiecień":
                return Calendar.APRIL;
            case "Maj":
                return Calendar.MAY;
            case "Czerwiec":
                return Calendar.JUNE;
            case "Lipiec":
                return Calendar.JULY;
            case "Sierpień":
                return Calendar.AUGUST;
            case "Wrzesień":
                return Calendar.SEPTEMBER;
            case "Październik":
                return Calendar.OCTOBER;
            case "Listopad":
                return Calendar.NOVEMBER;
            case "Grudzień":
                return Calendar.DECEMBER;
            default:
                return 123;
        }
    }

}
