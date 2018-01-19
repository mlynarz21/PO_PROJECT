package com.crashcourse.restclient.model;

public class ZamowienieZakupuModel extends ZamowienieModel {

	private javafx.beans.property.SimpleObjectProperty<com.crashcourse.restclient.datatype.enumeration.StatusDostawy> status;
	private javafx.beans.property.SimpleObjectProperty<KlientModel> klient;
	private javafx.beans.property.ObjectProperty<java.util.Date> terminRealizacji;
	private javafx.beans.property.SimpleObjectProperty<com.crashcourse.restclient.datatype.enumeration.TypOdbioru> typOdbioru;

	public javafx.beans.property.SimpleObjectProperty<com.crashcourse.restclient.datatype.enumeration.StatusDostawy> getStatus() {
		return this.status;
	}

	public void setStatus(javafx.beans.property.SimpleObjectProperty<com.crashcourse.restclient.datatype.enumeration.StatusDostawy> status) {
		this.status = status;
	}

	public javafx.beans.property.SimpleObjectProperty<KlientModel> getKlient() {
		return this.klient;
	}

	public void setKlient(javafx.beans.property.SimpleObjectProperty<KlientModel> klient) {
		this.klient = klient;
	}

	public javafx.beans.property.ObjectProperty<java.util.Date> getTerminRealizacji() {
		return this.terminRealizacji;
	}

	public void setTerminRealizacji(javafx.beans.property.ObjectProperty<java.util.Date> terminRealizacji) {
		this.terminRealizacji = terminRealizacji;
	}

	public javafx.beans.property.SimpleObjectProperty<com.crashcourse.restclient.datatype.enumeration.TypOdbioru> getTypOdbioru() {
		return this.typOdbioru;
	}

	public void setTypOdbioru(javafx.beans.property.SimpleObjectProperty<com.crashcourse.restclient.datatype.enumeration.TypOdbioru> typOdbioru) {
		this.typOdbioru = typOdbioru;
	}

	public javafx.beans.property.SimpleObjectProperty<com.crashcourse.restclient.datatype.enumeration.StatusDostawy> statusProperty() {
		// TODO - implement ZamowienieZakupuModel.statusProperty
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param status
	 */
	public void setStatus(com.crashcourse.restclient.datatype.enumeration.StatusDostawy status) {
		// TODO - implement ZamowienieZakupuModel.setStatus
		throw new UnsupportedOperationException();
	}

	public javafx.beans.property.SimpleObjectProperty<com.crashcourse.restclient.model.KlientModel> klientProperty() {
		// TODO - implement ZamowienieZakupuModel.klientProperty
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param klient
	 */
	public void setKlient(com.crashcourse.restclient.model.KlientModel klient) {
		// TODO - implement ZamowienieZakupuModel.setKlient
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param zamowienieZakupuTO
	 */
	public static ZamowienieZakupuModel fromZamowienieZakupuTo(com.crashcourse.restclient.datatype.ZamowienieZakupuTO zamowienieZakupuTO) {
		// TODO - implement ZamowienieZakupuModel.fromZamowienieZakupuTo
		throw new UnsupportedOperationException();
	}

}