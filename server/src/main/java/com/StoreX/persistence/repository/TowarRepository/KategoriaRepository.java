package com.StoreX.persistence.repository.TowarRepository;

import com.StoreX.persistence.entity.TowarEntities.Kategoria;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repozytorium używane do akcji z bazą danych oraz Kategoria Entity.
 */
public interface KategoriaRepository extends JpaRepository<Kategoria, Long> {
}
