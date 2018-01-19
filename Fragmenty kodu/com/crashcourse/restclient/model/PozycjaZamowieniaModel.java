package com.crashcourse.restclient.model;

public class PozycjaZamowieniaModel {

	private Long ID;
	private javafx.beans.property.DoubleProperty ilosc;
	private javafx.beans.property.DoubleProperty zrealizowano;
	private javafx.beans.property.SimpleObjectProperty<com.crashcourse.restclient.model.TowarModel> towar;
	private javafx.beans.property.SimpleObjectProperty<com.crashcourse.restclient.model.ZamowienieModel> zamowienie;

	public Long getID() {
		return this.ID;
	}

	public void setID(Long ID) {
		this.ID = ID;
	}

	public javafx.beans.property.DoubleProperty getIlosc() {
		return this.ilosc;
	}

	public void setIlosc(javafx.beans.property.DoubleProperty ilosc) {
		this.ilosc = ilosc;
	}

	public javafx.beans.property.DoubleProperty getZrealizowano() {
		return this.zrealizowano;
	}

	public void setZrealizowano(javafx.beans.property.DoubleProperty zrealizowano) {
		this.zrealizowano = zrealizowano;
	}

	public javafx.beans.property.SimpleObjectProperty<com.crashcourse.restclient.model.TowarModel> getTowar() {
		return this.towar;
	}

	public void setTowar(javafx.beans.property.SimpleObjectProperty<com.crashcourse.restclient.model.TowarModel> towar) {
		this.towar = towar;
	}

	public javafx.beans.property.SimpleObjectProperty<com.crashcourse.restclient.model.ZamowienieModel> getZamowienie() {
		return this.zamowienie;
	}

	public void setZamowienie(javafx.beans.property.SimpleObjectProperty<com.crashcourse.restclient.model.ZamowienieModel> zamowienie) {
		this.zamowienie = zamowienie;
	}

	/**
	 * 
	 * @param pozycjaZamowieniaTO
	 */
	public static PozycjaZamowieniaModel fromPozycjaZamowieniaTo(com.crashcourse.restclient.datatype.PozycjaZamowieniaTO pozycjaZamowieniaTO) {
		// TODO - implement PozycjaZamowieniaModel.fromPozycjaZamowieniaTo
		throw new UnsupportedOperationException();
	}

}