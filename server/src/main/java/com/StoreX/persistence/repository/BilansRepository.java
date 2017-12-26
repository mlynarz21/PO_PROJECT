package com.StoreX.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.StoreX.persistence.entity.Bilans;
import org.springframework.data.jpa.repository.Query;

public interface BilansRepository extends JpaRepository<Bilans, Long> {

    @Query(value = "select * from Bilans  order by data_bilansu limit 1 ", nativeQuery = true)
    Bilans findLastBilansByDate();
}
