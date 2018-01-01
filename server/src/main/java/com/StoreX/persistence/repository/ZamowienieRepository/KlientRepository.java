package com.StoreX.persistence.repository.ZamowienieRepository;

import com.StoreX.persistence.entity.ZamowienieEntities.Klient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KlientRepository extends JpaRepository<Klient, Long> {
}
