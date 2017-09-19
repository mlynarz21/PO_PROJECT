package com.crashcourse.restclient.view;

import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import com.crashcourse.restclient.controller.basic.DialogController;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;

/**
 * Binding between an fxml file and our controller.
 *
 * @author Mateusz
 */
public class FXMLDialog extends Stage {
    private String baseName = "com/crashcourse/restclient/bundle/base";
    private String pathToCss = "com/crashcourse/restclient/css/style.css";

    public FXMLDialog(DialogController controller, URL fxml, Window owner, StageStyle undecorated, Locale locale) throws IOException {
        this(controller, fxml, owner, StageStyle.DECORATED);
        ResourceBundle bundle = ResourceBundle.getBundle(baseName, locale);
        FXMLLoader loader = new FXMLLoader(fxml, bundle);
        loader.setControllerFactory(aClass -> controller);
        Scene scene = new Scene((Parent) loader.load());
        scene.getStylesheets().add(pathToCss);
        setScene(scene);
    }

    private FXMLDialog(final DialogController controller, URL fxml, Window owner, StageStyle style) throws IOException {
        super(style);
        initOwner(owner);
        initModality(Modality.WINDOW_MODAL);
        setResizable(true);

    }

}