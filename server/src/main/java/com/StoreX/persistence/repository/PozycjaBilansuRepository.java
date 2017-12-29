package com.StoreX.persistence.repository;

import com.StoreX.persistence.entity.PozycjaBilansu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PozycjaBilansuRepository extends JpaRepository<PozycjaBilansu, Long>{

    @Query(value = "select * from pozycja_bilansu", nativeQuery = true)
    List<PozycjaBilansu> findAllforMonthAndYear(int month, int year);

    @Query(value = "select * from pozycja_bilansu where bilans_id = ?1", nativeQuery = true)
    List<PozycjaBilansu> findAllForBilans(Long bilansId);
}
