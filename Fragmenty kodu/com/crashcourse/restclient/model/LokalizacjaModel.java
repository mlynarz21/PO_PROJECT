package com.crashcourse.restclient.model;

public class LokalizacjaModel {

	private Long ID;
	private StringProperty kod;
	private IntegerProperty numerRzedu;
	private IntegerProperty numerRegalu;
	private IntegerProperty numerSektora;

	public Long getID() {
		return this.ID;
	}

	public void setID(Long ID) {
		this.ID = ID;
	}

	public StringProperty getKod() {
		return this.kod;
	}

	public void setKod(StringProperty kod) {
		this.kod = kod;
	}

	public IntegerProperty getNumerRzedu() {
		return this.numerRzedu;
	}

	public void setNumerRzedu(IntegerProperty numerRzedu) {
		this.numerRzedu = numerRzedu;
	}

	public IntegerProperty getNumerRegalu() {
		return this.numerRegalu;
	}

	public void setNumerRegalu(IntegerProperty numerRegalu) {
		this.numerRegalu = numerRegalu;
	}

	public IntegerProperty getNumerSektora() {
		return this.numerSektora;
	}

	public void setNumerSektora(IntegerProperty numerSektora) {
		this.numerSektora = numerSektora;
	}

	/**
	 * 
	 * @param lokalizacjaTO
	 */
	public static LokalizacjaModel fromLokalizacjaTo(com.crashcourse.restclient.datatype.LokalizacjaTO lokalizacjaTO) {
		// TODO - implement LokalizacjaModel.fromLokalizacjaTo
		throw new UnsupportedOperationException();
	}

}