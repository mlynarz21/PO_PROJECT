package com.crashcourse.restclient.model;

public class KlientModel {

	private Long ID;
	private javafx.beans.property.StringProperty login;
	private javafx.beans.property.StringProperty imie;
	private javafx.beans.property.StringProperty nazwisko;
	private javafx.beans.property.StringProperty kodPocztowy;
	private javafx.beans.property.StringProperty ulica;
	private javafx.beans.property.StringProperty miasto;
	private javafx.beans.property.StringProperty numerDomu;
	private javafx.beans.property.StringProperty email;

	public Long getID() {
		return this.ID;
	}

	public void setID(Long ID) {
		this.ID = ID;
	}

	public javafx.beans.property.StringProperty getLogin() {
		return this.login;
	}

	public void setLogin(javafx.beans.property.StringProperty login) {
		this.login = login;
	}

	public javafx.beans.property.StringProperty getImie() {
		return this.imie;
	}

	public void setImie(javafx.beans.property.StringProperty imie) {
		this.imie = imie;
	}

	public javafx.beans.property.StringProperty getNazwisko() {
		return this.nazwisko;
	}

	public void setNazwisko(javafx.beans.property.StringProperty nazwisko) {
		this.nazwisko = nazwisko;
	}

	public javafx.beans.property.StringProperty getKodPocztowy() {
		return this.kodPocztowy;
	}

	public void setKodPocztowy(javafx.beans.property.StringProperty kodPocztowy) {
		this.kodPocztowy = kodPocztowy;
	}

	public javafx.beans.property.StringProperty getUlica() {
		return this.ulica;
	}

	public void setUlica(javafx.beans.property.StringProperty ulica) {
		this.ulica = ulica;
	}

	public javafx.beans.property.StringProperty getMiasto() {
		return this.miasto;
	}

	public void setMiasto(javafx.beans.property.StringProperty miasto) {
		this.miasto = miasto;
	}

	public javafx.beans.property.StringProperty getNumerDomu() {
		return this.numerDomu;
	}

	public void setNumerDomu(javafx.beans.property.StringProperty numerDomu) {
		this.numerDomu = numerDomu;
	}

	public javafx.beans.property.StringProperty getEmail() {
		return this.email;
	}

	public void setEmail(javafx.beans.property.StringProperty email) {
		this.email = email;
	}

	/**
	 * 
	 * @param klientTO
	 */
	public static KlientModel fromKlientTo(com.crashcourse.restclient.datatype.KlientTO klientTO) {
		// TODO - implement KlientModel.fromKlientTo
		throw new UnsupportedOperationException();
	}

}