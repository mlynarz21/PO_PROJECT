package com.crashcourse.restclient.controller.basic;

import java.util.Locale;

import com.crashcourse.restclient.controller.*;
import com.crashcourse.restclient.model.PozycjaZamowieniaModel;
import com.crashcourse.restclient.model.UmieszczenieModel;
import com.crashcourse.restclient.model.ZamowienieZakupuModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import com.crashcourse.restclient.view.FXMLDialog;

import javafx.stage.Stage;

/**
 * klasa zawierająca informacje o wszystkich dostępnych kontrolerach ekranów
 */
@Configuration
@Lazy
public class ScreensConfiguration {

    @Autowired
    private DialogManager manager;

    private Stage primaryStage;

    private Locale locale;

    /**
     * metoda ustawiająca podany primaryStage
     * @param primaryStage stage do ustawienia
     */
    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    /**
     * metoda ukazująca dialog FXML na ekranie
     * @param fxmlDialog dialog do ukazania
     */
    public void showDialog(FXMLDialog fxmlDialog) {
        primaryStage.setScene(fxmlDialog.getScene());
        primaryStage.show();
    }

    /**
     * metoda ustawiająca lokalne preferencje
     * @param locale ustawienia lokalnych prefrencji
     */
    public void setLocale(Locale locale) {
        this.locale = locale;

    }

    /**
     * metoda do pobrania aktualnych lokalnych ustawień
     * @return aktualnie ustawienia lokalne
     */
    public Locale getLocale() {

        return locale;
    }

    /**
     * spring bean dialogu Logowanie
     * @return dialog FXML do ustawienia
     */
    @Bean
    @Scope("prototype")
    public FXMLDialog loginDialog() {

        return manager.initializeDialog(loginController());
    }

    /**
     * metoda do ustawiania kontrolera do aktualnie wyświetlanego dialogu
     * @return nowy kontroler odpowiedzialny za dialog
     */
    @Bean
    @Scope("prototype")
    LoginController loginController() {
        return new LoginController(primaryStage);
    }

    /**
     * spring bean dialogu z błędem
     * @param errorType tekst błędu do wyświetlenia
     * @return dialog FXML do ustawienia
     */
    @Bean
    @Scope("prototype")
    ArtifactsBaseController informationErrorController(String errorType) {
        return new InformationErrorController(primaryStage, errorType);
    }

    /**
     * metoda do ustawiania kontrolera do aktualnie wyświetlanego dialogu
     * @param errorType tekst błędu do wyświetlenia
     * @return nowy kontroler odpowiedzialny za dialog
     */
    @Bean
    @Scope("prototype")
    public FXMLDialog informationErrorDialog(String errorType) {
        return manager.initializeDialog(informationErrorController(errorType));
    }

    /**
     * spring bean dialogu ekran głowny
     * @return dialog FXML do ustawienia
     */
    @Bean
    @Scope("prototype")
    public FXMLDialog mainScreenDialog() {

        return manager.initializeDialog(mainScreenController());
    }

    /**
     * metoda do ustawiania kontrolera do aktualnie wyświetlanego dialogu
     * @return nowy kontroler odpowiedzialny za dialog
     */
    @Bean
    @Scope("prototype")
    MainScreenController mainScreenController() {
        return new MainScreenController(primaryStage);
    }

    /**
     * spring bean dialogu z wyborem miesiąca bilansowania
     * @return dialog FXML do ustawienia
     */
    @Bean
    @Scope("prototype")
    public FXMLDialog monthPickupDialog() {
        return manager.initializeDialog(monthPickupController());
    }

    /**
     * metoda do ustawiania kontrolera do aktualnie wyświetlanego dialogu
     * @return nowy kontroler odpowiedzialny za dialog
     */
    @Bean
    @Scope("prototype")
    public MonthPickupController monthPickupController() {
        return new MonthPickupController(primaryStage);
    }

    /**
     * spring bean dialogu z wyborem zamówienia
     * @return dialog FXML do ustawienia
     */
    @Bean
    @Scope("prototype")
    public FXMLDialog orderPickupDialog() {
        return manager.initializeDialog(orderPickupController());
    }

    /**
     * metoda do ustawiania kontrolera do aktualnie wyświetlanego dialogu
     * @return nowy kontroler odpowiedzialny za dialog
     */
    @Bean
    @Scope("prototype")
    public OrderPickupController orderPickupController() {
        return new OrderPickupController(primaryStage);
    }

    /**
     * spring bean dialogu z listą produktów
     * @param zamowienieZakupu aktualnie procesowane zamówienie- wybrane przez użytkownika
     * @return dialog FXML do ustawienia
     */
    @Bean
    @Scope("prototype")
    public FXMLDialog productPickupDialog(ZamowienieZakupuModel zamowienieZakupu) {
        return manager.initializeDialog(productPickupController(zamowienieZakupu));
    }

    /**
     * metoda do ustawiania kontrolera do aktualnie wyświetlanego dialogu
     * @param zamowienieZakupu aktualnie procesowane zamówienie- wybrane przez użytkownika
     * @return nowy kontroler odpowiedzialny za dialog
     */
    @Bean
    @Scope("prototype")
    public ProductPickupController productPickupController(ZamowienieZakupuModel zamowienieZakupu) {
        return new ProductPickupController(primaryStage, zamowienieZakupu);
    }

    /**
     * spring bean dialogu z listą lokalizacji
     * @param zamowienieZakupu aktualnie procesowane zamówienie- wybrane przez użytkownika
     * @param pozycjaZamowienia aktualnie procesowana pozycja zamówienia - wybrana przez użytkownika
     * @return dialog FXML do ustawienia
     */
    @Bean
    @Scope("prototype")
    public FXMLDialog localizationPickupDialog(ZamowienieZakupuModel zamowienieZakupu, PozycjaZamowieniaModel pozycjaZamowienia) {
        return manager.initializeDialog(localizationPickupController(zamowienieZakupu, pozycjaZamowienia));
    }

    /**
     * metoda do ustawiania kontrolera do aktualnie wyświetlanego dialogu
     * @param zamowienieZakupu aktualnie procesowane zamówienie- wybrane przez użytkownika
     * @param pozycjaZamowienia aktualnie procesowana pozycja zamówienia - wybrana przez użytkownika
     * @return nowy kontroler odpowiedzialny za dialog
     */
    @Bean
    @Scope("prototype")
    public LocalizationPickupController localizationPickupController(ZamowienieZakupuModel zamowienieZakupu, PozycjaZamowieniaModel pozycjaZamowienia) {
        return new LocalizationPickupController(primaryStage, zamowienieZakupu, pozycjaZamowienia);
    }

    /**
     * spring bean dialogu z wyborem ilości pobieranego produktu
     * @param zamowienieZakupu aktualnie procesowane zamówienie- wybrane przez użytkownika
     * @param pozycjaZamowienia aktualnie procesowana pozycja zamówienia - wybrana przez użytkownika
     * @param umieszczenie aktualnie procesowane uieszczenie towaru - wybrane przez użytkownika
     * @return dialog FXML do ustawienia
     */
    @Bean
    @Scope("prototype")
    public FXMLDialog quantityProductDialog(ZamowienieZakupuModel zamowienieZakupu, PozycjaZamowieniaModel pozycjaZamowienia, UmieszczenieModel umieszczenie) {
        return manager.initializeDialog(quantityProductController(zamowienieZakupu, pozycjaZamowienia, umieszczenie));
    }

    /**
     * metoda do ustawiania kontrolera do aktualnie wyświetlanego dialogu
     * @param zamowienieZakupu aktualnie procesowane zamówienie- wybrane przez użytkownika
     * @param pozycjaZamowienia aktualnie procesowana pozycja zamówienia - wybrana przez użytkownika
     * @param umieszczenie aktualnie procesowane uieszczenie towaru - wybrane przez użytkownika
     * @return nowy kontroler odpowiedzialny za dialog
     */
    @Bean
    @Scope("prototype")
    public QuantityProductController quantityProductController(ZamowienieZakupuModel zamowienieZakupu, PozycjaZamowieniaModel pozycjaZamowienia, UmieszczenieModel umieszczenie) {
        return new QuantityProductController(primaryStage, zamowienieZakupu, pozycjaZamowienia, umieszczenie);
    }

    /**
     * spring bean dialogu z wysyłką zamówienia
     * @param zamowienieZakupu aktualnie procesowane zamówienie- wybrane przez użytkownika
     * @return dialog FXML do ustawienia
     */
    @Bean
    @Scope("prototype")
    public FXMLDialog shipmentDataDialog(ZamowienieZakupuModel zamowienieZakupu) {
        return manager.initializeDialog(shipmentDataController(zamowienieZakupu));
    }

    /**
     * metoda do ustawiania kontrolera do aktualnie wyświetlanego dialogu
     * @param zamowienieZakupu aktualnie procesowane zamówienie- wybrane przez użytkownika
     * @return nowy kontroler odpowiedzialny za dialog
     */
    @Bean
    @Scope("prototype")
    public ShipmentDataController shipmentDataController(ZamowienieZakupuModel zamowienieZakupu) {
        return new ShipmentDataController(primaryStage, zamowienieZakupu);
    }

    /**
     * spring bean dialogu z akceptacją wykonanego bilansu
     * @return dialog FXML do ustawienia
     */
    @Bean
    @Scope("prototype")
    public FXMLDialog balanceAcceptanceDialog() {
        return manager.initializeDialog(balanceAcceptanceController());
    }

    /**
     * metoda do ustawiania kontrolera do aktualnie wyświetlanego dialogu
     * @return nowy kontroler odpowiedzialny za dialog
     */
    @Bean
    @Scope("prototype")
    public BalanceAcceptanceController balanceAcceptanceController() {
        return new BalanceAcceptanceController(primaryStage);
    }

    /**
     * spring bean dialogu z powiadomieniem wysłania emaila
     * @return dialog FXML do ustawienia
     */
    @Bean
    @Scope("prototype")
    public FXMLDialog okEmailDialog() {
        return manager.initializeDialog(okEmailController());
    }

    /**
     * metoda do ustawiania kontrolera do aktualnie wyświetlanego dialogu
     * @return nowy kontroler odpowiedzialny za dialog
     */
    @Bean
    @Scope("prototype")
    public OKEmailController okEmailController() {
        return new OKEmailController(primaryStage);
    }

    /**
     * spring bean dialogu z błędem wybranej ilości
     * @param zamowienieZakupu aktualnie procesowane zamówienie- wybrane przez użytkownika
     * @param pozycjaZamowienia aktualnie procesowana pozycja zamówienia - wybrana przez użytkownika
     * @param umieszczenie aktualnie procesowane uieszczenie towaru - wybrane przez użytkownika
     * @param message wiadomość o błędzie użytkownika
     * @return dialog FXML do ustawienia
     */
    @Bean
    @Scope("prototype")
    public FXMLDialog okWrongQuantityDialog(ZamowienieZakupuModel zamowienieZakupu, PozycjaZamowieniaModel pozycjaZamowienia, UmieszczenieModel umieszczenie, String message) {
        return manager.initializeDialog(okWrongQuantityController(zamowienieZakupu, pozycjaZamowienia, umieszczenie, message));
    }

    /**
     * metoda do ustawiania kontrolera do aktualnie wyświetlanego dialogu
     * @param zamowienieZakupu aktualnie procesowane zamówienie- wybrane przez użytkownika
     * @param pozycjaZamowienia aktualnie procesowana pozycja zamówienia - wybrana przez użytkownika
     * @param umieszczenie aktualnie procesowane uieszczenie towaru - wybrane przez użytkownika
     * @param message wiadomość o błędzie użytkownika
     * @return nowy kontroler odpowiedzialny za dialog
     */
    @Bean
    @Scope("prototype")
    public OKWrongQuantityController okWrongQuantityController(ZamowienieZakupuModel zamowienieZakupu, PozycjaZamowieniaModel pozycjaZamowienia, UmieszczenieModel umieszczenie, String message) {
        return new OKWrongQuantityController(primaryStage, zamowienieZakupu, pozycjaZamowienia, umieszczenie, message);
    }

    /**
     * spring bean dialogu z niepoprawnie wybraną datą
     * @return dialog FXML do ustawienia
     */
    @Bean
    @Scope("prototype")
    public FXMLDialog okWrongDateDialog() {
        return manager.initializeDialog(okWrongDateController());
    }

    /**
     * metoda do ustawiania kontrolera do aktualnie wyświetlanego dialogu
     * @return nowy kontroler odpowiedzialny za dialog
     */
    @Bean
    @Scope("prototype")
    public OKWrongDateController okWrongDateController() {
        return new OKWrongDateController(primaryStage);
    }

    /**
     * spring bean dialogu informującego o braku produktu
     * @param zamowienieZakupu aktualnie procesowane zamówienie- wybrane przez użytkownika
     * @return dialog FXML do ustawienia
     */
    @Bean
    @Scope("prototype")
    public FXMLDialog okOutOFProductDialog(ZamowienieZakupuModel zamowienieZakupu) {
        return manager.initializeDialog(okOutOfProductController(zamowienieZakupu));
    }

    /**
     * metoda do ustawiania kontrolera do aktualnie wyświetlanego dialogu
     * @param zamowienieZakupu aktualnie procesowane zamówienie- wybrane przez użytkownika
     * @return nowy kontroler odpowiedzialny za dialog
     */
    @Bean
    @Scope("prototype")
    public OKOutOfProductController okOutOfProductController(ZamowienieZakupuModel zamowienieZakupu) {
        return new OKOutOfProductController(primaryStage, zamowienieZakupu);
    }

    /**
     * spring bean dialogu informującego o braku oczekujących zamówień
     * @return dialog FXML do ustawienia
     */
    @Bean
    @Scope("prototype")
    public FXMLDialog okNoWaitingOrdersDialog() {
        return manager.initializeDialog(okNoWaitingOrdersController());
    }

    /**
     * metoda do ustawiania kontrolera do aktualnie wyświetlanego dialogu
     * @return nowy kontroler odpowiedzialny za dialog
     */
    @Bean
    @Scope("prototype")
    public OKNoWaitingOrdersController okNoWaitingOrdersController() {
        return new OKNoWaitingOrdersController(primaryStage);
    }
}
