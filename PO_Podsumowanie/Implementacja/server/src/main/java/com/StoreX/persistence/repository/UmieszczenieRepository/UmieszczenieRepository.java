package com.StoreX.persistence.repository.UmieszczenieRepository;

import com.StoreX.persistence.entity.UmieszczenieEntities.Umieszczenie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Repozytorium używane do akcji z bazą danych oraz Umieszczenie Entity.
 */
public interface UmieszczenieRepository extends JpaRepository<Umieszczenie, Long>{

    /**
     * pobiera z bazy wszystkie umieszczenia dotyczące towaru o podanym ID
     * @param id ID towaru, którego dotyczy zapytanie
     * @return lista umieszczeń towaru o podanum ID
     */
    @Query(value = "select * from Umieszczenie where towar_id=?1", nativeQuery = true)
    List<Umieszczenie> findAllForTowar(Long id);

    /**
     * zmienia ilość towaru w umieszczeniu o podanym ID
     * @param id ID umieszczenia, którego dotyczy zapytanie
     * @param ilosc ilość dekrementowana
     * @return
     */
    @Modifying
    @Query(value = "update umieszczenie set iloscwlokalizacji = ?2 where id = ?1", nativeQuery = true)
    int realizacjaPozycjiZmowienia(Long id, double ilosc);
}
