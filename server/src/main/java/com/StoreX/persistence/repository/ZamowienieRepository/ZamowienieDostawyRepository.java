package com.StoreX.persistence.repository.ZamowienieRepository;

import com.StoreX.persistence.entity.ZamowienieEntities.ZamowienieDostawy;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repozytorium używane do akcji z bazą danych oraz ZamowienieDostawy Entity.
 */
public interface ZamowienieDostawyRepository extends JpaRepository<ZamowienieDostawy, Long> {
}
