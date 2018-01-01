package com.StoreX.persistence.repository.ZamowienieRepository;

import com.StoreX.persistence.entity.ZamowienieEntities.Zamowienie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ZamowienieRepositroy extends JpaRepository<Zamowienie,Long> {
}
