package com.StoreX.persistence.repository;

import com.StoreX.persistence.entity.Klient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KlientRepository extends JpaRepository<Klient, Long> {
}
