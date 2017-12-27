package com.StoreX.persistence.repository;

import com.StoreX.persistence.entity.Kategoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KategoriaRepository extends JpaRepository<Kategoria, Long> {
}
