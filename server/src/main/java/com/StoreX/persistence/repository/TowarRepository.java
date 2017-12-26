package com.StoreX.persistence.repository;

import com.StoreX.persistence.entity.Towar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TowarRepository extends JpaRepository<Towar, Long>{
}
