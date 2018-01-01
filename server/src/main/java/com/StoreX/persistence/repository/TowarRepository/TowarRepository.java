package com.StoreX.persistence.repository.TowarRepository;

import com.StoreX.persistence.entity.TowarEntities.Towar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TowarRepository extends JpaRepository<Towar, Long>{
}
