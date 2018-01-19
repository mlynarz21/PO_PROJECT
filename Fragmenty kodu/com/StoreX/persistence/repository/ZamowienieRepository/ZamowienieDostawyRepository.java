package com.StoreX.persistence.repository.ZamowienieRepository;

import org.springframework.data.jpa.repository.*;
import com.StoreX.persistence.entity.ZamowienieEntities.*;

public interface ZamowienieDostawyRepository extends JpaRepository<ZamowienieDostawy, Long> {
}