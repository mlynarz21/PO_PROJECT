package com.StoreX.persistence.repository.PrzyjecieWydanieRepository;

import com.StoreX.persistence.entity.PrzyjecieWydanieEntities.PrzyjecieZamowienia;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repozytorium używane do akcji z bazą danych oraz PrzyjecieZamowienia Entity.
 */
public interface PrzyjecieZamowieniaRepository extends JpaRepository<PrzyjecieZamowienia, Long> {
}
