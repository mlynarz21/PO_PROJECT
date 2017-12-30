package com.StoreX.persistence.repository;

import com.StoreX.persistence.entity.Zamowienie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ZamowienieRepositroy extends JpaRepository<Zamowienie,Long> {
}
