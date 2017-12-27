package com.crashcourse.restclient.controller;

import com.crashcourse.restclient.api.ArtifactRestServiceClient;
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

    @FXML
    public void initialize() {
        BilansTO bilans = bilansRestServiceClient.getLastBilans();

        ObservableList<String> items = FXCollections.observableArrayList(getMissingBalanceDates(bilans));
        datesList.setItems(items);
    }

    private List<String> getMissingBalanceDates(BilansTO bilans){
        List<String> toReturn= new ArrayList<>();
        Calendar currentDate = Calendar.getInstance();
        Calendar bilansDate = Calendar.getInstance();
        bilansDate.setTime(bilans.getDataBilansu());
        DateFormat df = new SimpleDateFormat("MM/yyyy");

        if(bilans==null)
            toReturn.add(new StringBuilder().append(getMonth(currentDate.get(Calendar.MONTH))).append(" ").append(currentDate.get(Calendar.YEAR)).toString());
        else {
            bilansDate.setTime(bilans.getDataBilansu());
            while (bilansDate.get(Calendar.YEAR) != currentDate.get(Calendar.YEAR) || bilansDate.get(Calendar.MONTH) < currentDate.get(Calendar.MONTH) && bilansDate.get(Calendar.YEAR) == currentDate.get(Calendar.YEAR)) {
                toReturn.add(new StringBuilder().append(getMonth(bilansDate.get(Calendar.MONTH))).append(" ").append(bilansDate.get(Calendar.YEAR)).toString());
                bilansDate.add(Calendar.MONTH, 1);
            }
        }
        return toReturn;
    }

    private String getMonth(int month){
        switch (month){
            case 1:
                return "Styczeń";
            case 2:
                return "Luty";
            case 3:
                return "Marzec";
            case 4:
                return "Kwiecień";
            case 5:
                return "Maj";
            case 6:
                return "Czerwiec";
            case 7:
                return "Lipiec";
            case 8:
                return "Sierpień";
            case 9:
                return "Wrzesień";
            case 10:
                return "Październik";
            case 11:
                return "Listopad";
            case 12:
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

    @FXML
    public void back() {
        FXMLDialog defaultDialog = getScreens().mainScreenDialog();
        getDialog().close();
        getScreens().showDialog(defaultDialog);
    }

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
