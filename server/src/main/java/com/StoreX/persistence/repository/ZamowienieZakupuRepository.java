package com.StoreX.persistence.repository;

import com.StoreX.persistence.entity.ZamowienieZakupu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ZamowienieZakupuRepository extends JpaRepository<ZamowienieZakupu, Long> {

    /*
    todo query statements needs to be changed probably
     */
    @Query(value = "select * from Zamowienie where dtype = 'ZamowienieZakupu' and  status = 'Zaakceptowane'", nativeQuery = true)
    List<ZamowienieZakupu> findAllAccepted();
}
