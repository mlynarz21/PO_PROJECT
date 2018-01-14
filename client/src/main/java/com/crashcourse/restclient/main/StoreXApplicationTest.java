package com.crashcourse.restclient.main;

import com.crashcourse.restclient.controller.basic.ScreensConfiguration;
import com.crashcourse.restclient.main.config.StoreXAppConfiguration;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import jdk.management.resource.internal.inst.StaticInstrumentation;
import org.glassfish.jersey.internal.util.ExceptionUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;

import javax.management.Query;
import java.util.Locale;
import java.util.Optional;

@Component
public class StoreXApplicationTest extends ApplicationTest {

    private ScreensConfiguration screens;
    private ApplicationContext context;

    @Override
    public void start(Stage stage) throws Exception {

        Locale locale = Locale.getDefault();
        screens.setLocale(locale);

        stage.setTitle("StoreX Application");
        screens.setPrimaryStage(stage);
        screens.loginDialog().show();
    }

    private void showErrorScreen(Thread t, Throwable e) {
        if (Platform.isFxApplicationThread()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
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
            Platform.exit();
        }

    }

    @Override
    public void init() throws Exception {
        context = new AnnotationConfigApplicationContext(StoreXAppConfiguration.class);
        screens = context.getBean(ScreensConfiguration.class);

        context.getBean(ScreensConfiguration.class);
    }


    @Before
    public void setUp() throws Exception {
    }
    @After
    public void tearDown() throws Exception {
        FxToolkit.hideStage();
        release(new KeyCode[]{});
        release(new MouseButton[]{});
    }

    //@Test
//    public void testBalanceAddition() {
//        clickOn("#username");
//        write("admin");
//        clickOn("#password");
//        write("topsecret");
//        clickOn("#login");
//        clickOn("#makeBalance");
//        clickOn("#datesList");
//        clickOn(".list-cell:first");
//        clickOn(".list-cell:filled");
//        clickOn(".list-cell:filled");
//        clickOn(".list-cell:filled");
//        clickOn(".list-cell:filled");
//        clickOn("#OK");
//        clickOn("#OK");
//    }

    @Test
    public void testLogInFail() {
        clickOn("#username");
        write("admin");
        clickOn("#password");
        write("to");
        clickOn("#login");
        clickOn("#OK");
    }

    @Test
    public void testLogInFailWithoutPassword() {
        clickOn("#username");
        write("admin");
        clickOn("#login");
        clickOn("#OK");
    }

    @Test
    public void testLogSuccess() {
        clickOn("#username");
        write("admin");
        clickOn("#password");
        write("topsecret");
        clickOn("#login");
        clickOn("#OK");
    }

    @Test
    public void testOrderCompletion() {
        //logowanie
        clickOn("#username");
        write("admin");
        clickOn("#password");
        write("topsecret");
        clickOn("#login");

        //kompletowanie
        clickOn("#completeOrder");
        //wybor zamowienia
        clickOn(600,200);
        clickOn("#OK");
//        //wybor produktu
//        clickOn(600,200);
//        clickOn("#OK");
//        //wybor lokalizacji
//        clickOn(600,200);
//        clickOn("#OK");
//        //wybor ilosci
//        clickOn("#quantityTextField");
//        write("12");
//        clickOn("#OK");

//        //wybor produktu
//        clickOn(600,200);
//        clickOn("#OK");
          //wybor lokalizacji
//        clickOn(600,200);
//        clickOn("#OK");
//        //wybor ilosci
//        write("12");
//        clickOn("#OK");
//        //akceptacja dialogu o blednej ilosci
//        clickOn("#OK");
//
//        //wybor ilosci
//        clickOn("#quantityTextField");
//        write("8");
//        clickOn("#OK");

        //wydawanie zamowienia
        clickOn("#send");
        clickOn(1200,500);
    }



}