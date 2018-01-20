import java.util.ArrayList;

public class Towar {
	private long _iD;
	private String _nazwa;
	private String _kod;
	private double _ilostan;
	private int _czas_zalegania;
	private double _ilosc_zablokowana;
	private boolean _zalega;
	private boolean _potrzebuje_zamówienia;
	private double _ilo?c_minimalna;
	public Jednostka _unnamed_Jednostka_;
	public Kategoria _unnamed_Kategoria_;
	public ArrayList<Umieszczenie> _unnamed_Umieszczenie_ = new ArrayList<Umieszczenie>();
	public ArrayList<PozycjaBilansu> _pozycjeBilansu = new ArrayList<PozycjaBilansu>();
	public ArrayList<PozycjaZamówienia> _pozycjeZamówienia = new ArrayList<PozycjaZamówienia>();
	public ArrayList<Pozycja_Wydania> _pozycjeWydania = new ArrayList<Pozycja_Wydania>();
	public ArrayList<Pozycja_Przyj?cia> _pozycjePrzyj?cia = new ArrayList<Pozycja_Przyj?cia>();
}