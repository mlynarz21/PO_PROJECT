package com.StoreX.persistence.repository.PrzyjecieWydanieRepository;

import com.StoreX.persistence.entity.PrzyjecieWydanieEntities.PozycjaPrzyjecia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Repozytorium używane do akcji z bazą danych oraz PozycjaPrzyjecia Entity.
 */
public interface PozycjaPrzyjeciaRepository extends JpaRepository<PozycjaPrzyjecia, Long> {

    /**
     * pobiera z bazy wszystkie pozycje przyjęć zamówień dla wskazanego okresu
     * @param month miesiąc za okres
     * @param year rok okresu
     * @return lista pozycji przyjęcia w danym okresie
     */
    @Query(value = "select p.* from pozycja_przyjecia p join przyjecie_zamowienia pz on p.przyjecie_zamowienia_id = pz.id  where month(pz.data) = ?1 and year(pz.data) = ?2 ", nativeQuery = true)
    List<PozycjaPrzyjecia> findAllForMonthAndYear(int month, int year);
}
