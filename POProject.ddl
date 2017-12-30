CREATE TABLE Towar (ID number(19) NOT NULL, Nazwa varchar2(255) NOT NULL UNIQUE, Kod varchar2(255) NOT NULL UNIQUE, Ilostan double precision NOT NULL, CzasZalegania number(10) NOT NULL, IloscZablokowana double precision NOT NULL, Zalega number(1) NOT NULL, PotrzebujeZamowienia number(1) NOT NULL, IloścMinimalna double precision NOT NULL, JednostkaID number(19) NOT NULL, KategoriaID number(19) NOT NULL, PRIMARY KEY (ID), CONSTRAINT IlostanGTzablokowana CHECK (Ilostan >= IloscZablokowana));
CREATE TABLE Lokalizacja (ID number(19) NOT NULL, RegałID number(19) NOT NULL, Kod varchar2(255) NOT NULL UNIQUE, NumerRzedu number(10) NOT NULL, NumerSektora number(10) NOT NULL, Zajeta number(1) NOT NULL, PRIMARY KEY (ID));
CREATE TABLE Dostawca (ID number(19) NOT NULL, Kod varchar2(255) NOT NULL UNIQUE, Nazwa varchar2(255) NOT NULL, PRIMARY KEY (ID));
CREATE TABLE Klient (ID number(19) NOT NULL, Nazwa varchar2(255) NOT NULL UNIQUE, Login varchar2(255) NOT NULL UNIQUE, Haslo varchar2(255) NOT NULL, KodPocztowy varchar2(255), Ulica varchar2(255), Miasto varchar2(255), Numer number(10), PRIMARY KEY (ID));
CREATE TABLE Umieszczenie (ID number(19) NOT NULL, IloscWLokalizacji double precision NOT NULL, LokalizacjaID number(19) NOT NULL, TowarID number(19) NOT NULL, PRIMARY KEY (ID));
CREATE TABLE Bilans (ID number(19) NOT NULL, Datawykonania date NOT NULL, Databilansu date NOT NULL UNIQUE, PRIMARY KEY (ID));
CREATE TABLE Regał (ID number(19) NOT NULL, PrzestrzenMagazynowaID number(19) NOT NULL, Numer number(10) NOT NULL, WspolrzednaX number(10) NOT NULL, WspolrzednaY number(10) NOT NULL, Liczbasektorów number(10) NOT NULL, Liczbapółek number(10) NOT NULL, PRIMARY KEY (ID));
CREATE TABLE PrzestrzeńMagazynowa (ID number(19) NOT NULL, PRIMARY KEY (ID));
CREATE TABLE PozycjaBilansu (ID number(19) NOT NULL, BilansID number(19) NOT NULL, TowarID number(19) NOT NULL, Ilosc double precision NOT NULL, PRIMARY KEY (ID), CONSTRAINT BilansTowar UNIQUE (BilansID, TowarID));
CREATE TABLE PozycjaZamówienia (ID number(19) NOT NULL, ZamówienieID number(19) NOT NULL, TowarID number(19) NOT NULL, Ilosc double precision NOT NULL, PRIMARY KEY (ID));
CREATE TABLE WydanieZamówienia (ID number(19) NOT NULL, Data date NOT NULL, ZamówienieZakupuZamówienieID number(19) NOT NULL, PRIMARY KEY (ID));
CREATE TABLE PozycjaPrzyjęcia (ID number(19) NOT NULL, PrzyjecieZamowieniaID number(19) NOT NULL, TowarID number(19) NOT NULL, Ilosc double precision NOT NULL, PRIMARY KEY (ID));
CREATE TABLE PozycjaWydania (ID number(19) NOT NULL, WydanieZamówieniaID number(19) NOT NULL, TowarID number(19) NOT NULL, Ilosc double precision NOT NULL, PRIMARY KEY (ID));
CREATE TABLE Magazynier (ID number(19) NOT NULL, PrzestrzenMagazynowaID number(19), Login varchar2(255) NOT NULL UNIQUE, Haslo varchar2(255) NOT NULL, NumerIdentyfikacyjny number(10) NOT NULL UNIQUE, PRIMARY KEY (ID));
CREATE TABLE ZamówienieDostawy (ZamówienieID number(19) NOT NULL, status varchar2(255) NOT NULL, DostawcaID number(19) NOT NULL, PRIMARY KEY (ZamówienieID));
CREATE TABLE ZamówienieZakupu (ZamówienieID number(19) NOT NULL, status nvarchar2(255) NOT NULL, typOdbioru varchar2(255) NOT NULL, terminRealizacji date NOT NULL, KlientID number(19) NOT NULL, PRIMARY KEY (ZamówienieID));
CREATE TABLE Jednostka (ID number(19) NOT NULL, Rodzaj varchar2(255) NOT NULL UNIQUE, PRIMARY KEY (ID));
CREATE TABLE Kategoria (ID number(19) NOT NULL, Kategoria varchar2(255) NOT NULL UNIQUE, PRIMARY KEY (ID));
CREATE TABLE Zamówienie (ID number(19) NOT NULL, Kod varchar2(255) NOT NULL UNIQUE, DataZlożenia date NOT NULL, Discriminator varchar2(255) NOT NULL, PRIMARY KEY (ID));
CREATE TABLE PrzyjęcieZamówienia (ID number(19) NOT NULL, Data date NOT NULL, ZamówienieDostawyZamówienieID number(19) NOT NULL, PRIMARY KEY (ID));
ALTER TABLE Umieszczenie ADD CONSTRAINT FKUmieszczen961 FOREIGN KEY (LokalizacjaID) REFERENCES Lokalizacja (ID);
ALTER TABLE Umieszczenie ADD CONSTRAINT FKUmieszczen274711 FOREIGN KEY (TowarID) REFERENCES Towar (ID);
ALTER TABLE Lokalizacja ADD CONSTRAINT "jest przypisana do" FOREIGN KEY (RegałID) REFERENCES Regał (ID);
ALTER TABLE Regał ADD CONSTRAINT "mieści się w  " FOREIGN KEY (PrzestrzenMagazynowaID) REFERENCES PrzestrzeńMagazynowa (ID);
ALTER TABLE PozycjaBilansu ADD CONSTRAINT dotyczy FOREIGN KEY (TowarID) REFERENCES Towar (ID);
ALTER TABLE PozycjaZamówienia ADD CONSTRAINT dotyczy2 FOREIGN KEY (TowarID) REFERENCES Towar (ID);
ALTER TABLE PozycjaBilansu ADD CONSTRAINT FKPozycjaBil961893 FOREIGN KEY (BilansID) REFERENCES Bilans (ID);
ALTER TABLE PozycjaPrzyjęcia ADD CONSTRAINT dotyczy3 FOREIGN KEY (TowarID) REFERENCES Towar (ID);
ALTER TABLE PozycjaWydania ADD CONSTRAINT dotyczy4 FOREIGN KEY (TowarID) REFERENCES Towar (ID);
ALTER TABLE PozycjaWydania ADD CONSTRAINT FKPozycjaWyd404343 FOREIGN KEY (WydanieZamówieniaID) REFERENCES WydanieZamówienia (ID);
ALTER TABLE Magazynier ADD CONSTRAINT obsluguje FOREIGN KEY (PrzestrzenMagazynowaID) REFERENCES PrzestrzeńMagazynowa (ID);
ALTER TABLE Towar ADD CONSTRAINT FKTowar339684 FOREIGN KEY (JednostkaID) REFERENCES Jednostka (ID);
ALTER TABLE Towar ADD CONSTRAINT FKTowar422879 FOREIGN KEY (KategoriaID) REFERENCES Kategoria (ID);
ALTER TABLE PozycjaZamówienia ADD CONSTRAINT FKPozycjaZam258943 FOREIGN KEY (ZamówienieID) REFERENCES Zamówienie (ID);
ALTER TABLE ZamówienieDostawy ADD CONSTRAINT FKZamówienie847980 FOREIGN KEY (ZamówienieID) REFERENCES Zamówienie (ID);
ALTER TABLE ZamówienieZakupu ADD CONSTRAINT FKZamówienie862025 FOREIGN KEY (ZamówienieID) REFERENCES Zamówienie (ID);
ALTER TABLE WydanieZamówienia ADD CONSTRAINT FKWydanieZam839961 FOREIGN KEY (ZamówienieZakupuZamówienieID) REFERENCES ZamówienieZakupu (ZamówienieID);
ALTER TABLE PozycjaPrzyjęcia ADD CONSTRAINT FKPozycjaPrz529802 FOREIGN KEY (PrzyjecieZamowieniaID) REFERENCES PrzyjęcieZamówienia (ID);
ALTER TABLE PrzyjęcieZamówienia ADD CONSTRAINT FKPrzyjęcieZ30799 FOREIGN KEY (ZamówienieDostawyZamówienieID) REFERENCES ZamówienieDostawy (ZamówienieID);
ALTER TABLE ZamówienieZakupu ADD CONSTRAINT FKZamówienie66373 FOREIGN KEY (KlientID) REFERENCES Klient (ID);
ALTER TABLE ZamówienieDostawy ADD CONSTRAINT FKZamówienie764256 FOREIGN KEY (DostawcaID) REFERENCES Dostawca (ID);
