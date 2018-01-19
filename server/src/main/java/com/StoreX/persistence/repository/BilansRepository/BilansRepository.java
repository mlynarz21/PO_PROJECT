package com.StoreX.persistence.repository.BilansRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.StoreX.persistence.entity.BilansEntities.Bilans;
import org.springframework.data.jpa.repository.Query;

/**
 * Repozytorium używane do akcji z bazą danych oraz Bilans Entity.
 */
public interface BilansRepository extends JpaRepository<Bilans, Long> {

    /**
     * pobiera z bazy bilans z najnowszą datą bilansowania
     * @return bilans z najnowszą datą bilansowania
     */
    @Query(value = "select * from Bilans order by data_bilansu desc limit 1 ", nativeQuery = true)
    Bilans findLastBilansByDate();

    /**
     * pobiera liczbę bilansów dla konkretnej daty bilansowania
     * @param month miesiąc bilansowania
     * @param year rok bilansowania
     * @return liczba bilansów dla wskazanej daty bilansowania
     */
    @Query(value = "select count(*) from  bilans where year(data_bilansu) = ?2 and month(data_bilansu) = ?1", nativeQuery = true)
    int findBilansForMonthAndYear(int month, int year);
}
