
package com.crashcourse.restclient.controller.basic;

import com.crashcourse.restclient.view.FXMLDialog;

import javafx.stage.Stage;

/**
 * interfejs kazdego kontrolera
 */
public interface DialogController {

    /**
     * metoda do pobrania ścieżki do dialogu FXML
     * @return scieżka do sialogu FXML
     */
    String getResourcePath();

    /**
     * metoda pobierająca stage
     * @return stage
     */
    Stage getPrimaryStage();

    /**
     * metoda służąda do ustawienia zawartosci ekranu na FXML podany pod ścieżką
     * @param fxmlDialog dialog FXML do ustawienia
     */
    void setDialog(FXMLDialog fxmlDialog);
}
