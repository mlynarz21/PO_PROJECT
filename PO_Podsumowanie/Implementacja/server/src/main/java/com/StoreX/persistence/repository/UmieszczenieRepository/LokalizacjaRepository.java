package com.StoreX.persistence.repository.UmieszczenieRepository;

import com.StoreX.persistence.entity.UmieszczenieEntities.Lokalizacja;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repozytorium używane do akcji z bazą danych oraz Lokalizacja Entity.
 */
public interface LokalizacjaRepository extends JpaRepository<Lokalizacja, Long> {
}
