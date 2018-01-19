package com.StoreX.persistence.repository.ZamowienieRepository;

import com.StoreX.persistence.entity.ZamowienieEntities.ZamowienieZakupu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Repozytorium używane do akcji z bazą danych oraz ZamowienieZakupu Entity.
 */
public interface ZamowienieZakupuRepository extends JpaRepository<ZamowienieZakupu, Long> {

    /*
    todo query statements needs to be changed probably
     */

    /**
     * pobiera z bazy wszystkie zamówienia o podanym statusie
     * @param status status szukanych zamówień
     * @return lista zamówień o podanym statusie
     */
    @Query(value = "select * from Zamowienie_zakupu natural join zamowienie where  status = ?1", nativeQuery = true)
    List<ZamowienieZakupu> findByStatus(String status);

    /**
     * zmienia status zamówienia o podanym ID
     * @param ID ID zamówienia, którego dotyczy zapytanie
     * @param statusWydania nowy status zamówienia
     */
    @Modifying
    @Query(value = "update Zamowienie_Zakupu natural join zamowienie set status = ?2 where id = ?1", nativeQuery = true)
    void updateStatusZamowienia(Long ID, String statusWydania);
}
