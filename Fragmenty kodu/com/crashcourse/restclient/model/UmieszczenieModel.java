package com.crashcourse.restclient.model;

public class UmieszczenieModel {

	private Long ID;
	private javafx.beans.property.DoubleProperty iloscWLokalizacji;
	private javafx.beans.property.SimpleObjectProperty<com.crashcourse.restclient.model.TowarModel> towar;
	private javafx.beans.property.SimpleObjectProperty<LokalizacjaModel> lokalizacja;

	public Long getID() {
		return this.ID;
	}

	public void setID(Long ID) {
		this.ID = ID;
	}

	public javafx.beans.property.DoubleProperty getIloscWLokalizacji() {
		return this.iloscWLokalizacji;
	}

	public void setIloscWLokalizacji(javafx.beans.property.DoubleProperty iloscWLokalizacji) {
		this.iloscWLokalizacji = iloscWLokalizacji;
	}

	public javafx.beans.property.SimpleObjectProperty<com.crashcourse.restclient.model.TowarModel> getTowar() {
		return this.towar;
	}

	public void setTowar(javafx.beans.property.SimpleObjectProperty<com.crashcourse.restclient.model.TowarModel> towar) {
		this.towar = towar;
	}

	public javafx.beans.property.SimpleObjectProperty<LokalizacjaModel> getLokalizacja() {
		return this.lokalizacja;
	}

	public void setLokalizacja(javafx.beans.property.SimpleObjectProperty<LokalizacjaModel> lokalizacja) {
		this.lokalizacja = lokalizacja;
	}

	/**
	 * 
	 * @param umieszczenieTO
	 */
	public static UmieszczenieModel fromUmieszenieTo(com.crashcourse.restclient.datatype.UmieszczenieTO umieszczenieTO) {
		// TODO - implement UmieszczenieModel.fromUmieszenieTo
		throw new UnsupportedOperationException();
	}

}