package com.StoreX.persistence.repository.TowarRepository;

import org.springframework.data.jpa.repository.*;
import com.StoreX.persistence.entity.TowarEntities.*;

public interface TowarRepository extends JpaRepository<Towar, Long> {
}