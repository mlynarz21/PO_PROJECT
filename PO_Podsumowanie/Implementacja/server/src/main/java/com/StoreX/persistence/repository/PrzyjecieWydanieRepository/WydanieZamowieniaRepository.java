package com.StoreX.persistence.repository.PrzyjecieWydanieRepository;

import com.StoreX.persistence.entity.PrzyjecieWydanieEntities.WydanieZamowienia;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repozytorium używane do akcji z bazą danych oraz WydanieZamowienia Entity.
 */
public interface WydanieZamowieniaRepository extends JpaRepository<WydanieZamowienia, Long> {
}
