package com.StoreX.persistence.repository.BilansRepository;

import com.StoreX.persistence.entity.BilansEntities.PozycjaBilansu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Repozytorium używane do akcji z bazą danych oraz PozycjaBilansu Entity.
 */
public interface PozycjaBilansuRepository extends JpaRepository<PozycjaBilansu, Long>{

    /**
     * pobiera z bazy wszystkie pozycje bilansu dla wskazanej daty bilansowania
     * @param month miesiąc bilansowania
     * @param year rok bilansowania
     * @return lista pozycji bilansu dla wskazanaej daty bilansowania
     */
    @Query(value = "select * from pozycja_bilansu", nativeQuery = true)
    List<PozycjaBilansu> findAllforMonthAndYear(int month, int year);

    /**
     * pobiera z bazy wszystkie pozycje bilansu dla wskazanego bilansu
     * @param bilansId id bilansu którego dotyczy zapytanie
     * @return lista pozycji bilansu o podanym ID
     */
    @Query(value = "select * from pozycja_bilansu where bilans_id = ?1", nativeQuery = true)
    List<PozycjaBilansu> findAllForBilans(Long bilansId);
}
