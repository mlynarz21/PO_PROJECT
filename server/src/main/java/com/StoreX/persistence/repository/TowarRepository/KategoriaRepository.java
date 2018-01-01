package com.StoreX.persistence.repository.TowarRepository;

import com.StoreX.persistence.entity.TowarEntities.Kategoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KategoriaRepository extends JpaRepository<Kategoria, Long> {
}
