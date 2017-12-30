package com.StoreX.persistence.repository;

import com.StoreX.persistence.entity.PozycjaPrzyjecia;
import com.StoreX.persistence.entity.PozycjaWydania;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PozycjaWydaniaRepository extends JpaRepository<PozycjaWydania, Long> {

    @Query(value = "select p.* from pozycja_wydania p join wydanie_zamowienia pz on p.wydanie_zamowienia_id = pz.id where month(pz.data) = ?1 and year(pz.data) = ?2 ", nativeQuery = true)
    List<PozycjaWydania> findAllForMonthAndYear(int month, int year);
}
