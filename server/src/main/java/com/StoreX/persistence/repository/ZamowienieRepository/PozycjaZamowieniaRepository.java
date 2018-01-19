package com.StoreX.persistence.repository.ZamowienieRepository;

import com.StoreX.persistence.entity.ZamowienieEntities.PozycjaZamowienia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Repozytorium używane do akcji z bazą danych oraz PozycjaZamowienia Entity.
 */
public interface PozycjaZamowieniaRepository extends JpaRepository<PozycjaZamowienia, Long> {

    /**
     * pobiera z bazy wszystkie pozycjeZamówienia zamówienia o podanym ID
     * @param id ID zamówienia, którego dotyczy zapytanie
     * @return lista pozycjiZamówienia zamówienia o podanym ID
     */
    @Query(value = "select * from Pozycja_Zamowienia where zamowienie_id=?1", nativeQuery = true)
    List<PozycjaZamowienia> findAllForZamowienie(Long id);

    /**
     * zmienia ilość zrealizowaną pozycjiZamówienia o podanym ID
     * @param id ID pozycji zamówienia, którego dotyczy zapytanie
     * @param ilosc inkrementowana ilość zrealizowana
     * @return
     */
    @Modifying
    @Query(value = "update pozycja_zamowienia set zrealizowano = ?2 where id = ?1", nativeQuery = true)
    int realizacjaPozycjiZmowienia(Long id, double ilosc);

    @Query(value = "select  zamowienie.dtype from pozycja_Zamowienia join zamowienie on zamowienie.id = pozycja_zamowienia.zamowienie_id where pozycja_zamowienia.id = ?1", nativeQuery = true)
    String getType(Long id);
}
