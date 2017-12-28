package com.StoreX.persistence.repository;

import com.StoreX.persistence.entity.PozycjaZamowienia;
import com.sun.xml.internal.bind.v2.model.core.ID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.naming.AuthenticationException;
import java.util.List;

public interface PozycjaZamowieniaRepository extends JpaRepository<PozycjaZamowienia, Long> {

    @Query(value = "select * from Pozycja_Zamowienia where zamowienie_id=?1", nativeQuery = true)
    List<PozycjaZamowienia> findAllForZamowienie(Long id);


    @Modifying
    @Query(value = "update pozycja_zamowienia set zrealizowano = ?2 where id = ?1", nativeQuery = true)
    int realizacjaPozycjiZmowienia(Long id, double ilosc);
}
