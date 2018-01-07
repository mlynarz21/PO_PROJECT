package com.StoreX.persistence.repository.ZamowienieRepository;

import com.StoreX.persistence.entity.ZamowienieEntities.PozycjaZamowienia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PozycjaZamowieniaRepository extends JpaRepository<PozycjaZamowienia, Long> {

    @Query(value = "select * from Pozycja_Zamowienia where zamowienie_id=?1", nativeQuery = true)
    List<PozycjaZamowienia> findAllForZamowienie(Long id);


    @Modifying
    @Query(value = "update pozycja_zamowienia set zrealizowano = ?2 where id = ?1", nativeQuery = true)
    int realizacjaPozycjiZmowienia(Long id, double ilosc);

    @Query(value = "select  zamowienie.dtype from pozycja_Zamowienia join zamowienie on zamowienie.id = pozycja_zamowienia.zamowienie_id where pozycja_zamowienia.id = ?1", nativeQuery = true)
    String getType(Long id);
}