package com.StoreX.persistence.repository.UmieszczenieRepository;

import com.StoreX.persistence.entity.UmieszczenieEntities.Umieszczenie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UmieszczenieRepository extends JpaRepository<Umieszczenie, Long>{

    @Query(value = "select * from Umieszczenie where towar_id=?1", nativeQuery = true)
    List<Umieszczenie> findAllForTowar(Long id);

    @Modifying
    @Query(value = "update umieszczenie set iloscwlokalizacji = ?2 where id = ?1", nativeQuery = true)
    int realizacjaPozycjiZmowienia(Long id, double ilosc);
}
