package com.crashcourse.restclient.view;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;

/**
 * klasa odpowiadająca za tworzenie instancji Alertów w programie
 */
public class AlertDialog {

    private static Alert alert;
    private static ButtonType buttonCancel;
    private static ButtonType buttonOK;

    private AlertDialog(){
    }

    /**
     * metoda dostępu do podstawowego alertu
     * @return alert
     */
    public Alert getAlert(){
        if (alert==null)
            alert = new Alert(Alert.AlertType.WARNING);

        alert.setTitle("Wydanie zamówienia");
        alert.setHeaderText("Czy na pewno chcesz wydać to zamówienie?\nTa akcja jest nieodwracalna");
        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.getStylesheets().add("com/crashcourse/restclient/css/alert.css");
        buttonOK = new ButtonType("OK");
        alert.getButtonTypes().setAll(buttonOK);
        return alert;
    }

    public static Alert getImplementationAlert(){
        if (alert==null)
            alert = new Alert(Alert.AlertType.WARNING);
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
    public static Alert getConfirmationAlert(){
        if (alert==null)
            alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Wydanie zamówienia");
        alert.setHeaderText("Czy na pewno chcesz wydać to zamówienie?\nTa akcja jest nieodwracalna");
        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.getStylesheets().add("com/crashcourse/restclient/css/alert.css");
        buttonCancel = new ButtonType("Anuluj");
        buttonOK = new ButtonType("Potwierdź");
        alert.getButtonTypes().setAll(buttonCancel, buttonOK);
        return alert;
    }

    public static ButtonType getButtonCancel() {
        return buttonCancel;
    }

    public static ButtonType getButtonOK() {
        return buttonOK;
    }
}
