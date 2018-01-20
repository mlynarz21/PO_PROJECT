CREATE TABLE Towar (ID bigint(19) AUTO_INCREMENT NOT NULL, Nazwa varchar(255) NOT NULL UNIQUE, Kod varchar(255) NOT NULL UNIQUE, Ilostan double  NOT NULL, CzasZalegania int(10) NOT NULL, IloscZablokowana double  NOT NULL, Zalega bit(1) NOT NULL, PotrzebujeZamowienia bit(1) NOT NULL, IloscMinimalna double  NOT NULL, JednostkaID bigint(19) NOT NULL, KategoriaID bigint(19) NOT NULL, PRIMARY KEY (ID));
CREATE TABLE Lokalizacja (ID bigint(19) AUTO_INCREMENT NOT NULL, RegalID bigint(19) NOT NULL, Kod varchar(255) NOT NULL UNIQUE, NumerRzedu int(10) NOT NULL, NumerSektora int(10) NOT NULL, PRIMARY KEY (ID));
CREATE TABLE Dostawca (ID bigint(19) AUTO_INCREMENT NOT NULL, Kod varchar(255) NOT NULL UNIQUE, Nazwa varchar(255) NOT NULL, PRIMARY KEY (ID));
CREATE TABLE Klient (ID bigint(19) AUTO_INCREMENT NOT NULL, Nazwa varchar(255) NOT NULL UNIQUE, Login varchar(255) NOT NULL UNIQUE, Haslo varchar(255) NOT NULL, KodPocztowy varchar(255), Ulica varchar(255), Miasto varchar(255), Numer int(10), PRIMARY KEY (ID));
CREATE TABLE Umieszczenie (ID bigint(19) AUTO_INCREMENT NOT NULL, IloscWLokalizacji double  NOT NULL, LokalizacjaID bigint(19) NOT NULL UNIQUE, TowarID bigint(19) NOT NULL, PRIMARY KEY (ID));
CREATE TABLE Bilans (ID bigint(19) AUTO_INCREMENT NOT NULL, DataWykonania date NOT NULL, DataBilansu date NOT NULL UNIQUE, PRIMARY KEY (ID));
CREATE TABLE Regal (ID bigint(19) AUTO_INCREMENT NOT NULL, PrzestrzenMagazynowaID bigint(19) NOT NULL, Numer int(10) NOT NULL, WspolrzednaX int(10) NOT NULL, WspolrzednaY int(10) NOT NULL, LiczbasSektorow int(10) NOT NULL, LiczbaPolek int(10) NOT NULL, PRIMARY KEY (ID));
CREATE TABLE PrzestrzenMagazynowa (ID bigint(19) AUTO_INCREMENT NOT NULL, PRIMARY KEY (ID));
CREATE TABLE PozycjaBilansu (ID bigint(19) AUTO_INCREMENT NOT NULL, BilansID bigint(19) NOT NULL, TowarID bigint(19) NOT NULL, Ilosc double  NOT NULL, PRIMARY KEY (ID));
CREATE TABLE PozycjaZamowienia (ID bigint(19) AUTO_INCREMENT NOT NULL, ZamowienieID bigint(19) NOT NULL, TowarID bigint(19) NOT NULL, Ilosc double  NOT NULL, Zrealizowano double, PRIMARY KEY (ID));
CREATE TABLE WydanieZamowienia (ID bigint(19) AUTO_INCREMENT NOT NULL, Data date NOT NULL, ZamowienieZakupuZamowienieID bigint(19) UNIQUE, PRIMARY KEY (ID));
CREATE TABLE PozycjaPrzyjecia (ID bigint(19) AUTO_INCREMENT NOT NULL, PrzyjecieZamowieniaID bigint(19) NOT NULL, TowarID bigint(19) NOT NULL, Ilosc double  NOT NULL, PRIMARY KEY (ID));
CREATE TABLE PozycjaWydania (ID bigint(19) AUTO_INCREMENT NOT NULL, WydanieZamowieniaID bigint(19) NOT NULL, TowarID bigint(19) NOT NULL, Ilosc double  NOT NULL, PRIMARY KEY (ID));
CREATE TABLE Magazynier (ID bigint(19) AUTO_INCREMENT NOT NULL, PrzestrzenMagazynowaID bigint(19), Login varchar(255) NOT NULL UNIQUE, Haslo varchar(255) NOT NULL, NumerIdentyfikacyjny int(10) NOT NULL UNIQUE, PRIMARY KEY (ID));
CREATE TABLE ZamowienieDostawy (ZamowienieID bigint(19) NOT NULL, DostawcaID bigint(19) NOT NULL, status varchar(255) NOT NULL, PRIMARY KEY (ZamowienieID));
CREATE TABLE ZamowienieZakupu (ZamowienieID bigint(19) NOT NULL, KlientID bigint(19) NOT NULL, status varchar(255) NOT NULL, typOdbioru varchar(255) NOT NULL, terminRealizacji date NOT NULL, PRIMARY KEY (ZamowienieID));
CREATE TABLE Jednostka (ID bigint(19) AUTO_INCREMENT NOT NULL, Rodzaj varchar(255) NOT NULL UNIQUE, PRIMARY KEY (ID));
CREATE TABLE Kategoria (ID bigint(19) AUTO_INCREMENT NOT NULL, Kategoria varchar(255) NOT NULL UNIQUE, PRIMARY KEY (ID));
CREATE TABLE Zamowienie (ID bigint(19) AUTO_INCREMENT NOT NULL, Kod varchar(255) NOT NULL UNIQUE, DataZlozenia date NOT NULL, Discriminator varchar(255) NOT NULL, PRIMARY KEY (ID));
CREATE TABLE PrzyjecieZamowienia (ID bigint(19) AUTO_INCREMENT NOT NULL, Data date NOT NULL, ZamowienieDostawyZamowienieID bigint(19) UNIQUE, PRIMARY KEY (ID));

ALTER TABLE WydanieZamowienia ADD CONSTRAINT WZ_FK_ZZZ FOREIGN KEY (ZamowienieZakupuZamowienieID) REFERENCES ZamowienieZakupu (ZamowienieID);

ALTER TABLE PrzyjecieZamowienia ADD CONSTRAINT PZ_FK_ZDZ FOREIGN KEY (ZamowienieDostawyZamowienieID) REFERENCES ZamowienieDostawy (ZamowienieID);

ALTER TABLE Bilans ADD CONSTRAINT BI_CH_DWY_DBI CHECK (DataWykonania > DataBilansu);

ALTER TABLE Klient ADD CONSTRAINT KL_CH_NUM CHECK (Numer >= 0);

ALTER TABLE Magazynier ADD CONSTRAINT MA_FK_PRZ FOREIGN KEY (PrzestrzenMagazynowaID) REFERENCES PrzestrzenMagazynowa (ID);
ALTER TABLE Magazynier ADD CONSTRAINT MA_CH_NUM CHECK (NumerIdentyfikacyjny >= 0);

ALTER TABLE ZamowienieZakupu ADD CONSTRAINT ZZ_FK_ZAM FOREIGN KEY (ZamowienieID) REFERENCES Zamowienie (ID);
ALTER TABLE ZamowienieZakupu ADD CONSTRAINT ZZ_FK_KLI FOREIGN KEY (KlientID) REFERENCES Klient (ID);

ALTER TABLE ZamowienieDostawy ADD CONSTRAINT ZD_FK_ZAM FOREIGN KEY (ZamowienieID) REFERENCES Zamowienie (ID);
ALTER TABLE ZamowienieDostawy ADD CONSTRAINT ZD_FK_DOS FOREIGN KEY (DostawcaID) REFERENCES Dostawca (ID);

ALTER TABLE PozycjaZamowienia ADD CONSTRAINT PZ_FK_TOW FOREIGN KEY (TowarID) REFERENCES Towar (ID);
ALTER TABLE PozycjaZamowienia ADD CONSTRAINT PZ_FK_ZAM FOREIGN KEY (ZamowienieID) REFERENCES Zamowienie (ID);
ALTER TABLE PozycjaZamowienia ADD CONSTRAINT PZ_CH_ILO CHECK (Ilosc > 0);
ALTER TABLE PozycjaZamowienia ADD CONSTRAINT PZ_CH_ZRE CHECK (Zrealizowano >= 0);
ALTER TABLE PozycjaZamowienia ADD CONSTRAINT PZ_CH_ZRE_ILO CHECK (Zrealizowano <= Ilosc);

ALTER TABLE PozycjaWydania ADD CONSTRAINT PW_FK_TOW FOREIGN KEY (TowarID) REFERENCES Towar (ID);
ALTER TABLE PozycjaWydania ADD CONSTRAINT PW_FK_WZA FOREIGN KEY (WydanieZamowieniaID) REFERENCES WydanieZamowienia (ID);
ALTER TABLE PozycjaWydania ADD CONSTRAINT PW_CH_ILO CHECK (Ilosc > 0);


ALTER TABLE PozycjaPrzyjecia ADD CONSTRAINT PP_FK_TOW FOREIGN KEY (TowarID) REFERENCES Towar (ID);
ALTER TABLE PozycjaPrzyjecia ADD CONSTRAINT PP_FK_PZA FOREIGN KEY (PrzyjecieZamowieniaID) REFERENCES PrzyjecieZamowienia (ID);
ALTER TABLE PozycjaPrzyjecia ADD CONSTRAINT PP_CH_ILO CHECK (Ilosc > 0);

ALTER TABLE PozycjaBilansu ADD CONSTRAINT PB_FK_TOW FOREIGN KEY (TowarID) REFERENCES Towar (ID);
ALTER TABLE PozycjaBilansu ADD CONSTRAINT PB_FK_BIL FOREIGN KEY (BilansID) REFERENCES Bilans (ID);
ALTER TABLE PozycjaBilansu ADD CONSTRAINT PB_CH_ILO CHECK (Ilosc >= 0);
ALTER TABLE PozycjaBilansu ADD CONSTRAINT PB_UN_BIL_TOW UNIQUE (BilansID, TowarID);

ALTER TABLE Umieszczenie ADD CONSTRAINT UM_FK_LOK FOREIGN KEY (LokalizacjaID) REFERENCES Lokalizacja (ID);
ALTER TABLE Umieszczenie ADD CONSTRAINT UM_FK_TOW FOREIGN KEY (TowarID) REFERENCES Towar (ID);
ALTER TABLE Umieszczenie ADD CONSTRAINT UM_CH_ILO CHECK (IloscWLokalizacji >= 0);

ALTER TABLE Towar ADD CONSTRAINT TO_FK_JED FOREIGN KEY (JednostkaID) REFERENCES Jednostka (ID);
ALTER TABLE Towar ADD CONSTRAINT TO_FK_KAT FOREIGN KEY (KategoriaID) REFERENCES Kategoria (ID);
ALTER TABLE Towar ADD CONSTRAINT TO_CH_ILO CHECK (Ilostan >= 0);
ALTER TABLE Towar ADD CONSTRAINT TO_CH_ILO_IZA CHECK (Ilostan >= IloscZablokowana);
ALTER TABLE Towar ADD CONSTRAINT TO_CH_CZA CHECK (CzasZalegania > 0);
ALTER TABLE Towar ADD CONSTRAINT TO_CH_MIN CHECK (IloscMinimalna >= 0);

ALTER TABLE Regal ADD CONSTRAINT RE_FK_PRZ FOREIGN KEY (PrzestrzenMagazynowaID) REFERENCES PrzestrzenMagazynowa (ID);
ALTER TABLE Regal ADD CONSTRAINT RE_CH_LSE CHECK (LiczbasSektorow > 0);
ALTER TABLE Regal ADD CONSTRAINT RE_CH_LPO CHECK (LiczbaPolek > 0);
ALTER TABLE Regal ADD CONSTRAINT RE_CH_NUM CHECK (Numer > 0);

ALTER TABLE Lokalizacja ADD CONSTRAINT LO_FK_REG FOREIGN KEY (RegalID) REFERENCES Regal (ID);
ALTER TABLE Lokalizacja ADD CONSTRAINT LO_CH_NSE CHECK (NumerSektora > 0);
ALTER TABLE Lokalizacja ADD CONSTRAINT LO_CH_NRZ CHECK (NumerRzedu > 0);
