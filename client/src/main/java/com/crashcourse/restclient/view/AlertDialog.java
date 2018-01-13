package com.crashcourse.restclient.view;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;

/**
 * klasa odpowiadająca za tworzenie instancji Alertów w programie
 */
public class AlertDialog {

    private Alert alert = new Alert(Alert.AlertType.WARNING);
    private ButtonType buttonCancel;
    private ButtonType buttonOK;

    public AlertDialog(){
    }

    /**
     * metoda dostępu do podstawowego alertu
     * @return alert
     */
    public Alert getAlert(){
        alert.setTitle("Wydanie zamówienia");
        alert.setHeaderText("Czy na pewno chcesz wydać to zamówienie?\nTa akcja jest nieodwracalna");
        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.getStylesheets().add("com/crashcourse/restclient/css/alert.css");
        buttonOK = new ButtonType("OK");
        alert.getButtonTypes().setAll(buttonOK);
        return alert;
    }

    public Alert getImplementationAlert(){
        alert.setTitle("Funkcjonalność nieobsługiwana");
        alert.setHeaderText("Wygląda na to, że dana funkcjonalność nie jest jeszcze dostępna!");
        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.getStylesheets().add("com/crashcourse/restclient/css/alert.css");
        buttonOK = new ButtonType("OK");
        alert.getButtonTypes().setAll(buttonOK);
        return alert;
    }

    /**
     * metoda dostępu do alertu wydanie
     * @return alert wydania
     */
    public Alert getConfirmationAlert(){
        alert.setTitle("Wydanie zamówienia");
        alert.setHeaderText("Czy na pewno chcesz wydać to zamówienie?\nTa akcja jest nieodwracalna");
        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.getStylesheets().add("com/crashcourse/restclient/css/alert.css");
        buttonCancel = new ButtonType("Anuluj");
        buttonOK = new ButtonType("OK");
        alert.getButtonTypes().setAll(buttonCancel, buttonOK);
        return alert;
    }

    public ButtonType getButtonCancel() {
        return buttonCancel;
    }

    public ButtonType getButtonOK() {
        return buttonOK;
    }
}
