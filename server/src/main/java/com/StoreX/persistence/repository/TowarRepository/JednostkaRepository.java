package com.StoreX.persistence.repository.TowarRepository;

import com.StoreX.persistence.entity.TowarEntities.Jednostka;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repozytorium używane do akcji z bazą danych oraz Jednostka Entity.
 */
public interface JednostkaRepository extends JpaRepository<Jednostka, Long> {
}
