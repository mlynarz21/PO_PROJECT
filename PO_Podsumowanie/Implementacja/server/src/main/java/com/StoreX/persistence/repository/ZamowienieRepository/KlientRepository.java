package com.StoreX.persistence.repository.ZamowienieRepository;

import com.StoreX.persistence.entity.ZamowienieEntities.Klient;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repozytorium używane do akcji z bazą danych oraz Klient Entity.
 */
public interface KlientRepository extends JpaRepository<Klient, Long> {
}
