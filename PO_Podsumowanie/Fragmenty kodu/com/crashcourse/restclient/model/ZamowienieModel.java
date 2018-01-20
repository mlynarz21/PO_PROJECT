package com.crashcourse.restclient.model;

public abstract class ZamowienieModel {

	private Long ID;
	private javafx.beans.property.StringProperty kod;
	private javafx.beans.property.ObjectProperty<java.util.Date> dataZlozenia;

	public Long getID() {
		return this.ID;
	}

	public void setID(Long ID) {
		this.ID = ID;
	}

	public javafx.beans.property.StringProperty getKod() {
		return this.kod;
	}

	public void setKod(javafx.beans.property.StringProperty kod) {
		this.kod = kod;
	}

	public javafx.beans.property.ObjectProperty<java.util.Date> getDataZlozenia() {
		return this.dataZlozenia;
	}

	public void setDataZlozenia(javafx.beans.property.ObjectProperty<java.util.Date> dataZlozenia) {
		this.dataZlozenia = dataZlozenia;
	}

}