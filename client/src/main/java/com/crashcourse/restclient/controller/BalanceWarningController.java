package com.crashcourse.restclient.controller;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;

public class BalanceWarningController {

    private Alert alert = new Alert(Alert.AlertType.WARNING);
    private ButtonType buttonCancel;
    private ButtonType buttonOK;

    public BalanceWarningController(){
        alert.setTitle("Wydanie zamówienia");
        alert.setHeaderText("Czy na pewno chcesz wydać to zamówienie?\nTa akcja jest nieodwracalna");
        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.getStylesheets().add("com/crashcourse/restclient/css/alert.css");
        buttonCancel = new ButtonType("Anuluj");
        buttonOK = new ButtonType("OK");
        alert.getButtonTypes().setAll(buttonCancel, buttonOK);
    }

    public Alert getAlert(){
        return alert;
    }

    public ButtonType getButtonCancel() {
        return buttonCancel;
    }

    public ButtonType getButtonOK() {
        return buttonOK;
    }
}
