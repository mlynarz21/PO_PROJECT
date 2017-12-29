package com.StoreX.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.StoreX.persistence.entity.Bilans;
import org.springframework.data.jpa.repository.Query;

public interface BilansRepository extends JpaRepository<Bilans, Long> {

    @Query(value = "select * from Bilans order by data_bilansu desc limit 1 ", nativeQuery = true)
    Bilans findLastBilansByDate();

    @Query(value = "select count(*) from  bilans where year(data_bilansu) = ?2 and month(data_bilansu) = ?1", nativeQuery = true)
    int findBilansForMonthAndYear(int month, int year);
}
