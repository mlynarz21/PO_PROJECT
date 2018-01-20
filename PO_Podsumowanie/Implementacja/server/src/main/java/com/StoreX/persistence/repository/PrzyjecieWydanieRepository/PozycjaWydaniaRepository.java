package com.StoreX.persistence.repository.PrzyjecieWydanieRepository;

import com.StoreX.persistence.entity.PrzyjecieWydanieEntities.PozycjaWydania;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Repozytorium używane do akcji z bazą danych oraz PozycjaWydania Entity.
 */
public interface PozycjaWydaniaRepository extends JpaRepository<PozycjaWydania, Long> {

    /**
     * pobiera z bazy wszystkie pozycje wydań zamówień dla wskazanego okresu
     * @param month miesiąc za okres
     * @param year rok okresu
     * @return lista pozycji przyjęcia w danym okresie
     */
    @Query(value = "select p.* from pozycja_wydania p join wydanie_zamowienia pz on p.wydanie_zamowienia_id = pz.id where month(pz.data) = ?1 and year(pz.data) = ?2 ", nativeQuery = true)
    List<PozycjaWydania> findAllForMonthAndYear(int month, int year);
}
