package com.StoreX.persistence.repository;

import com.StoreX.persistence.entity.Lokalizacja;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LokalizacjaRepository extends JpaRepository<Lokalizacja, Long> {
}
