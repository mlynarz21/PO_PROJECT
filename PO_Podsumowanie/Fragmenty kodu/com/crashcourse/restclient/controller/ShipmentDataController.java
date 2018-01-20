package com.crashcourse.restclient.controller;

import com.crashcourse.restclient.model.*;

public class ShipmentDataController extends ArtifactsBaseController {

	@Autowired
	private com.crashcourse.restclient.main.config.StoreXSecurityContext context;
	@FXML
	private javafx.scene.control.Label nameLabel;
	@FXML
	private javafx.scene.control.Label surnameLabel;
	@FXML
	private javafx.scene.control.Label streetLabel;
	@FXML
	private javafx.scene.control.Label postalCodeLabel;
	private ZamowienieZakupuModel zamowienieZakupu;

	/**
	 * 
	 * @param primaryStage
	 * @param zamowienieZakupu
	 */
	public ShipmentDataController(javafx.stage.Stage primaryStage, ZamowienieZakupuModel zamowienieZakupu) {
		// TODO - implement ShipmentDataController.ShipmentDataController
		throw new UnsupportedOperationException();
	}

	@FXML
	public void initialize() {
		// TODO - implement ShipmentDataController.initialize
		throw new UnsupportedOperationException();
	}

	@FXML
	public void close() {
		// TODO - implement ShipmentDataController.close
		throw new UnsupportedOperationException();
	}

	@Override
	public String getResourcePath() {
		// TODO - implement ShipmentDataController.getResourcePath
		throw new UnsupportedOperationException();
	}

	@FXML
	public void proceed() {
		// TODO - implement ShipmentDataController.proceed
		throw new UnsupportedOperationException();
	}

}