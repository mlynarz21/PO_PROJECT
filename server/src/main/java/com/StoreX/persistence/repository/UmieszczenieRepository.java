package com.StoreX.persistence.repository;

import com.StoreX.persistence.entity.PozycjaZamowienia;
import com.StoreX.persistence.entity.Umieszczenie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UmieszczenieRepository extends JpaRepository<Umieszczenie, Long>{

    @Query(value = "select * from Umieszczenie where towar_id=?1", nativeQuery = true)
    List<Umieszczenie> findAllForTowar(Long id);
}
