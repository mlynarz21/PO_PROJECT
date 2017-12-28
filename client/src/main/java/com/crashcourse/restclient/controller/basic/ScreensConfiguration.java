package com.crashcourse.restclient.controller.basic;

import java.util.Locale;

import com.crashcourse.restclient.controller.*;
import com.crashcourse.restclient.model.PozycjaZamowieniaModel;
import com.crashcourse.restclient.model.ZamowienieZakupuModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import com.crashcourse.restclient.view.FXMLDialog;

import javafx.stage.Stage;

@Configuration
@Lazy
public class ScreensConfiguration {

    @Autowired
    private DialogManager manager;

    private Stage primaryStage;

    private Locale locale;

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void showDialog(FXMLDialog fxmlDialog) {
        primaryStage.setScene(fxmlDialog.getScene());
        primaryStage.show();
    }

    public void setLocale(Locale locale) {
        this.locale = locale;

    }

    public Locale getLocale() {

        return locale;
    }

    @Bean
    @Scope("prototype")
    public FXMLDialog loginDialog() {

        return manager.initializeDialog(loginController());
    }

    @Bean
    @Scope("prototype")
    LoginController loginController() {
        return new LoginController(primaryStage);
    }


    @Bean
    @Scope("prototype")
    ArtifactsBaseController informationErrorController(String errorType) {
        return new InformationErrorController(primaryStage, errorType);
    }

    @Bean
    @Scope("prototype")
    public FXMLDialog informationErrorDialog(String errorType) {
        return manager.initializeDialog(informationErrorController(errorType));
    }

    @Bean
    @Scope("prototype")
    public FXMLDialog mainScreenDialog() {

        return manager.initializeDialog(mainScreenController());
    }

    @Bean
    @Scope("prototype")
    MainScreenController mainScreenController() {
        return new MainScreenController(primaryStage);
    }

    @Bean
    @Scope("prototype")
    public FXMLDialog monthPickupDialog() {
        return manager.initializeDialog(monthPickupController());
    }

    @Bean
    @Scope("prototype")
    public MonthPickupController monthPickupController() {
        return new MonthPickupController(primaryStage);
    }

    @Bean
    @Scope("prototype")
    public FXMLDialog orderPickupDialog() {
        return manager.initializeDialog(orderPickupController());
    }

    @Bean
    @Scope("prototype")
    public OrderPickupController orderPickupController() {
        return new OrderPickupController(primaryStage);
    }

    @Bean
    @Scope("prototype")
    public FXMLDialog productPickupDialog(ZamowienieZakupuModel zamowienieZakupu) {
        return manager.initializeDialog(productPickupController(zamowienieZakupu));
    }

    @Bean
    @Scope("prototype")
    public ProductPickupController productPickupController(ZamowienieZakupuModel zamowienieZakupu) {
        return new ProductPickupController(primaryStage, zamowienieZakupu);
    }

    @Bean
    @Scope("prototype")
    public FXMLDialog localizationPickupDialog(ZamowienieZakupuModel zamowienieZakupu, PozycjaZamowieniaModel pozycjaZamowienia) {
        return manager.initializeDialog(localizationPickupController(zamowienieZakupu, pozycjaZamowienia));
    }

    @Bean
    @Scope("prototype")
    public LocalizationPickupController localizationPickupController(ZamowienieZakupuModel zamowienieZakupu, PozycjaZamowieniaModel pozycjaZamowienia) {
        return new LocalizationPickupController(primaryStage, zamowienieZakupu, pozycjaZamowienia);
    }

    @Bean
    @Scope("prototype")
    public FXMLDialog quantityProductDialog() {
        return manager.initializeDialog(quantityProductController());
    }

    @Bean
    @Scope("prototype")
    public QuantityProductController quantityProductController() {
        return new QuantityProductController(primaryStage);
    }

    @Bean
    @Scope("prototype")
    public FXMLDialog shipmentDataDialog() {
        return manager.initializeDialog(shipmentDataController());
    }

    @Bean
    @Scope("prototype")
    public ShipmentDataController shipmentDataController() {
        return new ShipmentDataController(primaryStage);
    }

    @Bean
    @Scope("prototype")
    public FXMLDialog balanceAcceptanceDialog() {
        return manager.initializeDialog(balanceAcceptanceController());
    }

    @Bean
    @Scope("prototype")
    public BalanceAcceptanceController balanceAcceptanceController() {
        return new BalanceAcceptanceController(primaryStage);
    }

    @Bean
    @Scope("prototype")
    public FXMLDialog okEmailDialog() {
        return manager.initializeDialog(okEmailController());
    }

    @Bean
    @Scope("prototype")
    public OKEmailController okEmailController() {
        return new OKEmailController(primaryStage);
    }

    @Bean
    @Scope("prototype")
    public FXMLDialog okWrongQuantityDialog() {
        return manager.initializeDialog(okWrongQuantityController());
    }

    @Bean
    @Scope("prototype")
    public OKWrongQuantityController okWrongQuantityController() {
        return new OKWrongQuantityController(primaryStage);
    }

    @Bean
    @Scope("prototype")
    public FXMLDialog okWrongDateDialog() {
        return manager.initializeDialog(okWrongDateController());
    }

    @Bean
    @Scope("prototype")
    public OKWrongDateController okWrongDateController() {
        return new OKWrongDateController(primaryStage);
    }

    @Bean
    @Scope("prototype")
    public FXMLDialog okOutOFProductDialog() {
        return manager.initializeDialog(okOutOfProductController());
    }

    @Bean
    @Scope("prototype")
    public OKOutOfProductController okOutOfProductController() {
        return new OKOutOfProductController(primaryStage);
    }

    @Bean
    @Scope("prototype")
    public FXMLDialog okNoWaitingOrdersDialog() {
        return manager.initializeDialog(okNoWaitingOrdersController());
    }

    @Bean
    @Scope("prototype")
    public OKNoWaitingOrdersController okNoWaitingOrdersController() {
        return new OKNoWaitingOrdersController(primaryStage);
    }





    @Bean
    @Scope("prototype")
    WelcomeController welcomeController() {
        return new WelcomeController(primaryStage);
    }

    @Bean
    @Scope("prototype")
    DefaultDialogController defaultController() {
        return new DefaultDialogController(primaryStage);
    }

    @Bean
    @Scope("prototype")
    public FXMLDialog defaultDialog() {
        return manager.initializeDialog(defaultController());
    }

    @Bean
    @Scope("prototype")
    ArtifactsBaseController artifactListController() {
        return new ArtifactListController(primaryStage);
    }

    @Bean
    @Scope("prototype")
    public FXMLDialog artifactListDialog() {
        return manager.initializeDialog(artifactListController());
    }

    @Bean
    @Scope("prototype")
    ArtifactsBaseController artifactListAdminController() {
        return new ArtifactListAdminController(primaryStage);
    }

    @Bean
    @Scope("prototype")
    public FXMLDialog artifactListAdminDialog() {
        return manager.initializeDialog(artifactListAdminController());
    }

    @Bean
    @Scope("prototype")
    ArtifactsBaseController registerController() {
        return new RegisterController(primaryStage);
    }

    @Bean
    @Scope("prototype")
    public FXMLDialog registerDialog() {
        return manager.initializeDialog(registerController());
    }




    /*
    @Bean
    @Scope("prototype")
    ArtifactsBaseController informationErrorController() {
    	return new InformationErrorController(primaryStage);
	}
    
    @Bean
    @Scope("prototype")
	public FXMLDialog informationErrorDialog() {
		return manager.initializeDialog(informationErrorController());
    }
    */
	
	



}
