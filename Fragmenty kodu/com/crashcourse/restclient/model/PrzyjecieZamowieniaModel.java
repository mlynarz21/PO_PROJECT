package com.crashcourse.restclient.model;

public class PrzyjecieZamowieniaModel {

	private Long ID;
	private javafx.beans.property.ObjectProperty<java.util.Date> data;
	private javafx.beans.property.SimpleObjectProperty<com.crashcourse.restclient.model.ZamowienieDostawyModel> zamowienie;

	public Long getID() {
		return this.ID;
	}

	public void setID(Long ID) {
		this.ID = ID;
	}

	public javafx.beans.property.ObjectProperty<java.util.Date> getData() {
		return this.data;
	}

	public void setData(javafx.beans.property.ObjectProperty<java.util.Date> data) {
		this.data = data;
	}

	public javafx.beans.property.SimpleObjectProperty<com.crashcourse.restclient.model.ZamowienieDostawyModel> getZamowienie() {
		return this.zamowienie;
	}

	public void setZamowienie(javafx.beans.property.SimpleObjectProperty<com.crashcourse.restclient.model.ZamowienieDostawyModel> zamowienie) {
		this.zamowienie = zamowienie;
	}

	/**
	 * 
	 * @param przyjecieZamowieniaTO
	 */
	public static PrzyjecieZamowieniaModel fromZamowienieZakupuTo(com.crashcourse.restclient.datatype.PrzyjecieZamowieniaTO przyjecieZamowieniaTO) {
		// TODO - implement PrzyjecieZamowieniaModel.fromZamowienieZakupuTo
		throw new UnsupportedOperationException();
	}

}