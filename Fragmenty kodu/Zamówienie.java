import java.util.ArrayList;

public abstract class Zamówienie {
	private long _iD;
	private String _kod;
	private DateTime _dataZlo?enia;
	public ArrayList<PozycjaZamówienia> _pozycjeZamówienia = new ArrayList<PozycjaZamówienia>();
}