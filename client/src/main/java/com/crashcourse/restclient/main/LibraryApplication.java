package com.crashcourse.restclient.main;

import java.util.Locale;
import java.util.Optional;

import org.glassfish.jersey.internal.util.ExceptionUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.crashcourse.restclient.controller.basic.ScreensConfiguration;
import com.crashcourse.restclient.main.config.LibraryAppConfiguration;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

@Component
public class LibraryApplication extends Application {

    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(LibraryApplication.class);

    private ApplicationContext context;

    private ScreensConfiguration screens;

    public static void main(String[] args) {

        launch(args);

    }

    @Override
    public void start(Stage stage) throws Exception {
        LOGGER.info("Application start requested");
        Thread.setDefaultUncaughtExceptionHandler(this::showErrorScreen);

        String string = getParameters().getNamed().get("locale");

        Locale locale = Optional.ofNullable(string).map(Locale::forLanguageTag).orElse(Locale.getDefault());
        screens.setLocale(locale);

        stage.setTitle("Library Application");
        screens.setPrimaryStage(stage);
        screens.loginDialog().show();
    }

    void showErrorScreen(Thread t, Throwable e) {
        LOGGER.error("UncaughtException!:", e);
        if (Platform.isFxApplicationThread()) {
            LOGGER.info("FX thread detected. Showing error dialog");
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("An Error occured");

            TextArea textArea = new TextArea(ExceptionUtils.exceptionStackTraceAsString(e));
            textArea.setEditable(false);
            textArea.setWrapText(true);

            textArea.setMaxWidth(Double.MAX_VALUE);
            textArea.setMaxHeight(Double.MAX_VALUE);

            GridPane expContent = new GridPane();
            expContent.setMaxWidth(Double.MAX_VALUE);
            expContent.add(textArea, 0, 1);
            alert.getDialogPane().setExpandableContent(expContent);
            alert.showAndWait();
        }
        else {
            LOGGER.info("No FX thread detected. Exiting Application!");
            Platform.exit();
        }

    }

    @Override
    public void init() throws Exception {
        LOGGER.info("Setting up context...");
        context = new AnnotationConfigApplicationContext(LibraryAppConfiguration.class);
        LOGGER.info("Context startup done.");
        screens = context.getBean(ScreensConfiguration.class);

        context.getBean(ScreensConfiguration.class);

    }
}
