package com.crashcourse.restclient.main;

import com.crashcourse.restclient.api.impl.TestGeneratorClientImpl;
import com.crashcourse.restclient.controller.basic.ScreensConfiguration;
import com.crashcourse.restclient.main.config.StoreXAppConfiguration;
import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.glassfish.jersey.internal.util.ExceptionUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;

import java.util.Locale;

@Component
public class StoreXApplicationTest extends ApplicationTest {

    private ScreensConfiguration screens;
    private ApplicationContext context;
    private TestGeneratorClientImpl testGeneratorClient;

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
        testGeneratorClient = new TestGeneratorClientImpl();
    }


    @Before
    public void setUp() throws Exception {
        testGeneratorClient.turncateAll();
    }

    @After
    public void tearDown() throws Exception {
        FxToolkit.hideStage();
        release(new KeyCode[]{});
        release(new MouseButton[]{});
    }

    @Test
    public void testLogInFailWrongCredentials() {
        clickOn("#username");
        sleep(1000);
        write("admin");
        sleep(1000);
        clickOn("#password");
        sleep(1000);
        write("to");
        sleep(1000);
        clickOn("#login");
        sleep(1000);
        clickOn("#OK");
    }

    @Test
    public void testLogInFailWithoutPassword() {
        clickOn("#username");
        sleep(1000);
        write("admin");
        sleep(1000);
        clickOn("#login");
        sleep(1000);
        clickOn("#OK");
    }

    @Test
    public void testLogInFailWithoutUsername() {
        clickOn("#password");
        sleep(1000);
        write("topsecret");
        sleep(1000);
        clickOn("#login");
        sleep(1000);
        clickOn("#OK");
    }


    @Test
    public void testLogSuccess() {
        clickOn("#username");
        sleep(1000);
        write("admin");
        sleep(1000);
        clickOn("#password");
        sleep(1000);
        write("topsecret");
        sleep(1000);
        clickOn("#login");
    }

//    @Test
//    public void testBalanceAddition() {
//        testGeneratorClient.addTest();
//        clickOn("#username");
//        sleep(1000);
//        write("admin");
//        sleep(1000);
//        clickOn("#password");
//        sleep(1000);
//        write("topsecret");
//        sleep(1000);
//        clickOn("#login");
//        sleep(1000);
//        clickOn("#makeBalance");
//        sleep(1000);
//        clickOn((Node)lookup(".list-cell").nth(0).query());
//        sleep(3000);
//        clickOn("#OK");
//        sleep(2000);
//        clickOn("#OKAcceptance");
//    }
//
//    @Test
//    public void testBalanceAdditionWithNoBalanceInDB() {
//        clickOn("#username");
//        sleep(1000);
//        write("admin");
//        sleep(1000);
//        clickOn("#password");
//        sleep(1000);
//        write("topsecret");
//        sleep(1000);
//        clickOn("#login");
//        sleep(1000);
//        clickOn("#makeBalance");
//        sleep(1000);
//        clickOn((Node)lookup(".list-cell").nth(0).query());
//        sleep(3000);
//        clickOn("#OK");
//        sleep(2000);
//        clickOn("#OKAcceptance");
//    }
//
//    @Test
//    public void testBalanceWrongDate() {
//        testGeneratorClient.addTest();
//        clickOn("#username");
//        sleep(1000);
//        write("admin");
//        sleep(1000);
//        clickOn("#password");
//        sleep(1000);
//        write("topsecret");
//        sleep(1000);
//        clickOn("#login");
//        sleep(1000);
//        clickOn("#makeBalance");
//        sleep(1000);
//        clickOn((Node)lookup(".list-cell").nth(1).query());
//        sleep(3000);
//        clickOn("#OK");
//        sleep(2000);
//        clickOn("#OKDate");
//    }

    @Test
    public void testNoWaitingOrders() {
        //logowanie
        clickOn("#username");
        sleep(1000);
        write("admin");
        sleep(1000);
        clickOn("#password");
        sleep(1000);
        write("topsecret");
        sleep(1000);
        clickOn("#login");

        //kompletowanie
        sleep(3000);
        clickOn("#completeOrder");

        //akceptacja dialogu oczekiwania
        sleep(3000);
        clickOn("#OKNoWaiting");
    }

    @Test
    public void testNoSuchProductAvailable() {
        testGeneratorClient.add002();
        //logowanie
        clickOn("#username");
        sleep(1000);
        write("admin");
        sleep(1000);
        clickOn("#password");
        sleep(1000);
        write("topsecret");
        sleep(1000);
        clickOn("#login");

        //kompletowanie
        sleep(3000);
        clickOn("#completeOrder");

        //wybor zamowienia
        sleep(2000);
        clickOn((Node)lookup(".table-cell").nth(2).query());
        sleep(3000);
        clickOn("#OK");

        //wybor produktu
        sleep(2000);
        clickOn((Node)lookup(".table-cell").nth(3).query());
        sleep(3000);
        clickOn("#OK");

        //akceptacja dialogu braku produktu
        sleep(2000);
        clickOn("#OKNoProduct");
    }

    @Test
    public void testWrongQuantitiesAmountBiggerThanLocated() {
        testGeneratorClient.add003_9();
        //logowanie
        clickOn("#username");
        sleep(1000);
        write("admin");
        sleep(1000);
        clickOn("#password");
        sleep(1000);
        write("topsecret");
        sleep(1000);
        clickOn("#login");

        //kompletowanie
        sleep(1000);
        clickOn("#completeOrder");

        //wybor zamowienia
        sleep(1000);
        clickOn((Node)lookup(".table-cell").nth(2).query());
        sleep(3000);
        clickOn("#OK");

        //wybor produktu
        sleep(1000);
        clickOn((Node)lookup(".table-cell").nth(3).query());
        sleep(3000);
        clickOn("#OK");

        //wybor lokalizacji
        sleep(1000);
        clickOn((Node)lookup(".table-cell").nth(1).query());
        sleep(3000);
        clickOn("#OK");

        //wybor ilosci
        sleep(3000);
        doubleClickOn("#quantityTextField");
        sleep(1000);
        write("7");
        sleep(3000);
        clickOn("#OK");

        //akceptacja dialogu o blednej
        sleep(2000);
        clickOn("#OKWrongQuantity");
    }

    @Test
    public void testWrongQuantitiesAmountBiggerThanOrdered() {
        testGeneratorClient.add004_5_6_7_8_10();
        //logowanie
        clickOn("#username");
        sleep(1000);
        write("admin");
        sleep(1000);
        clickOn("#password");
        sleep(1000);
        write("topsecret");
        sleep(1000);
        clickOn("#login");

        //kompletowanie
        sleep(1000);
        clickOn("#completeOrder");

        //wybor zamowienia
        sleep(1000);
        clickOn((Node)lookup(".table-cell").nth(2).query());
        sleep(3000);
        clickOn("#OK");

        //wybor produktu
        sleep(1000);
        clickOn((Node)lookup(".table-cell").nth(3).query());
        sleep(3000);
        clickOn("#OK");

        //wybor lokalizacji
        sleep(1000);
        clickOn((Node)lookup(".table-cell").nth(1).query());
        sleep(3000);
        clickOn("#OK");

        //wybor ilosci
        sleep(3000);
        doubleClickOn("#quantityTextField");
        sleep(1000);
        write("10");
        sleep(3000);
        clickOn("#OK");

        //akceptacja dialogu o blednej
        sleep(2000);
        clickOn("#OKWrongQuantity");
    }

    @Test
    public void testWrongQuantitiesAmountZero() {
        testGeneratorClient.add004_5_6_7_8_10();
        //logowanie
        clickOn("#username");
        sleep(1000);
        write("admin");
        sleep(1000);
        clickOn("#password");
        sleep(1000);
        write("topsecret");
        sleep(1000);
        clickOn("#login");

        //kompletowanie
        sleep(1000);
        clickOn("#completeOrder");

        //wybor zamowienia
        sleep(1000);
        clickOn((Node)lookup(".table-cell").nth(2).query());
        sleep(3000);
        clickOn("#OK");

        //wybor produktu
        sleep(1000);
        clickOn((Node)lookup(".table-cell").nth(3).query());
        sleep(3000);
        clickOn("#OK");

        //wybor lokalizacji
        sleep(1000);
        clickOn((Node)lookup(".table-cell").nth(1).query());
        sleep(3000);
        clickOn("#OK");

        //wybor ilosci
        sleep(3000);
        doubleClickOn("#quantityTextField");
        sleep(1000);
        write("0");
        sleep(3000);
        clickOn("#OK");

        //akceptacja dialogu o blednej
        sleep(2000);
        clickOn("#OKWrongQuantity");
    }

    @Test
    public void testWrongQuantitiesAmountLessThanZero() {
        testGeneratorClient.add004_5_6_7_8_10();
        //logowanie
        clickOn("#username");
        sleep(1000);
        write("admin");
        sleep(1000);
        clickOn("#password");
        sleep(1000);
        write("topsecret");
        sleep(1000);
        clickOn("#login");

        //kompletowanie
        sleep(1000);
        clickOn("#completeOrder");

        //wybor zamowienia
        sleep(1000);
        clickOn((Node)lookup(".table-cell").nth(2).query());
        sleep(3000);
        clickOn("#OK");

        //wybor produktu
        sleep(1000);
        clickOn((Node)lookup(".table-cell").nth(3).query());
        sleep(3000);
        clickOn("#OK");

        //wybor lokalizacji
        sleep(1000);
        clickOn((Node)lookup(".table-cell").nth(1).query());
        sleep(3000);
        clickOn("#OK");

        //wybor ilosci
        sleep(3000);
        doubleClickOn("#quantityTextField");
        sleep(1000);
        write("-1");
        sleep(3000);
        clickOn("#OK");

        //akceptacja dialogu o blednej
        sleep(2000);
        clickOn("#OKWrongQuantity");
    }

    @Test
    public void testWrongQuantitiesAmountNotNumeric() {
        testGeneratorClient.add004_5_6_7_8_10();
        //logowanie
        clickOn("#username");
        sleep(1000);
        write("admin");
        sleep(1000);
        clickOn("#password");
        sleep(1000);
        write("topsecret");
        sleep(1000);
        clickOn("#login");

        //kompletowanie
        sleep(1000);
        clickOn("#completeOrder");

        //wybor zamowienia
        sleep(1000);
        clickOn((Node)lookup(".table-cell").nth(2).query());
        sleep(3000);
        clickOn("#OK");

        //wybor produktu
        sleep(1000);
        clickOn((Node)lookup(".table-cell").nth(3).query());
        sleep(3000);
        clickOn("#OK");

        //wybor lokalizacji
        sleep(1000);
        clickOn((Node)lookup(".table-cell").nth(1).query());
        sleep(3000);
        clickOn("#OK");

        //wybor ilosci
        sleep(3000);
        doubleClickOn("#quantityTextField");
        sleep(1000);
        write("test1");
        sleep(3000);
        clickOn("#OK");

        //akceptacja dialogu o blednej
        sleep(2000);
        clickOn("#OKWrongQuantity");
    }

    @Test
    public void testOrderCompletionDefaultQuantity() {
        testGeneratorClient.add004_5_6_7_8_10();
        //logowanie
        clickOn("#username");
        sleep(1000);
        write("admin");
        sleep(1000);
        clickOn("#password");
        sleep(1000);
        write("topsecret");
        sleep(1000);
        clickOn("#login");

        //kompletowanie
        sleep(1000);
        clickOn("#completeOrder");

        //wybor zamowienia
        sleep(1000);
        clickOn((Node)lookup(".table-cell").nth(2).query());
        sleep(3000);
        clickOn("#OK");

        //wybor produktu
        sleep(1000);
        clickOn((Node)lookup(".table-cell").nth(3).query());
        sleep(3000);
        clickOn("#OK");

        //wybor lokalizacji
        sleep(1000);
        clickOn((Node)lookup(".table-cell").nth(1).query());
        sleep(3000);
        clickOn("#OK");

        //wybor ilosci
        sleep(3000);
        clickOn("#OK");

        //powrot do ekranu z produktami
        sleep(5000);

    }

    @Test
    public void testOrderCompletionPlacementDeletion() {
        testGeneratorClient.add003_9();
        //logowanie
        clickOn("#username");
        sleep(1000);
        write("admin");
        sleep(1000);
        clickOn("#password");
        sleep(1000);
        write("topsecret");
        sleep(1000);
        clickOn("#login");

        //kompletowanie
        sleep(1000);
        clickOn("#completeOrder");

        //wybor zamowienia
        sleep(1000);
        clickOn((Node)lookup(".table-cell").nth(2).query());
        sleep(3000);
        clickOn("#OK");

        //wybor produktu
        sleep(1000);
        clickOn((Node)lookup(".table-cell").nth(3).query());
        sleep(3000);
        clickOn("#OK");

        //wybor lokalizacji
        sleep(1000);
        clickOn((Node)lookup(".table-cell").nth(1).query());
        sleep(3000);
        clickOn("#OK");

        //wybor ilosci
        sleep(3000);
        clickOn("#OK");

        //powrot do ekranu z produktem
        sleep(2000);

        //wybor produktu
        sleep(1000);
        clickOn((Node)lookup(".table-cell").nth(3).query());
        sleep(3000);
        clickOn("#OK");
        sleep(3000);

    }

    @Test
    public void testOrderCompletionDelivery() {
        testGeneratorClient.add004_5_6_7_8_10();
        //logowanie
        clickOn("#username");
        sleep(1000);
        write("admin");
        sleep(1000);
        clickOn("#password");
        sleep(1000);
        write("topsecret");
        sleep(1000);
        clickOn("#login");

        //kompletowanie
        sleep(1000);
        clickOn("#completeOrder");

        //wybor zamowienia
        sleep(1000);
        clickOn((Node)lookup(".table-cell").nth(2).query());
        sleep(3000);
        clickOn("#OK");

        //wydawanie zamowienia
        sleep(1000);
        clickOn("#send");
        sleep(3000);
        clickOn((Node)lookup(NodeMatchers.hasText("Potwierdź")).nth(0).query());
        moveTo(12,12);

        //akceptacja wysylki
        sleep(3000);
        clickOn("#OKShipment");
    }

    @Test
    public void testOrderCompletionEmail() {
        testGeneratorClient.add011();
        //logowanie
        clickOn("#username");
        sleep(1000);
        write("admin");
        sleep(1000);
        clickOn("#password");
        sleep(1000);
        write("topsecret");
        sleep(1000);
        clickOn("#login");

        //kompletowanie
        sleep(1000);
        clickOn("#completeOrder");

        //wybor zamowienia
        sleep(1000);
        clickOn((Node)lookup(".table-cell").nth(1).query());
        sleep(3000);
        clickOn("#OK");

        //wydawanie zamowienia
        sleep(1000);
        clickOn("#send");
        sleep(3000);
        clickOn((Node)lookup(NodeMatchers.hasText("Potwierdź")).nth(0).query());
        moveTo(12,12);

        //akceptacja wysylki
        sleep(3000);
        clickOn("#OKEmail");
    }
}