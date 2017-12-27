package com.StoreX.persistence.repository;

import com.StoreX.persistence.entity.Jednostka;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JednostkaRepository extends JpaRepository<Jednostka, Long> {
}
