package com.crashcourse.restclient.view;

public class AlertDialog {

	private javafx.scene.control.Alert alert = new Alert(Alert.AlertType.WARNING);
	private javafx.scene.control.ButtonType buttonCancel;
	private javafx.scene.control.ButtonType buttonOK;

	public javafx.scene.control.Alert getAlert() {
		return this.alert;
	}

	public javafx.scene.control.ButtonType getButtonCancel() {
		return this.buttonCancel;
	}

	public javafx.scene.control.ButtonType getButtonOK() {
		return this.buttonOK;
	}

	public AlertDialog() {
		// TODO - implement AlertDialog.AlertDialog
		throw new UnsupportedOperationException();
	}

	public javafx.scene.control.Alert getImplementationAlert() {
		// TODO - implement AlertDialog.getImplementationAlert
		throw new UnsupportedOperationException();
	}

	public javafx.scene.control.Alert getConfirmationAlert() {
		// TODO - implement AlertDialog.getConfirmationAlert
		throw new UnsupportedOperationException();
	}

}