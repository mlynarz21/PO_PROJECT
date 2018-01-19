package com.StoreX.persistence.repository.ZamowienieRepository;

import org.springframework.data.jpa.repository.*;
import com.StoreX.persistence.entity.ZamowienieEntities.*;

public interface PozycjaZamowieniaRepository extends JpaRepository<PozycjaZamowienia, Long> {

	/**
	 * 
	 * @param id
	 */
	@Query(value="select * from Pozycja_Zamowienia where zamowienie_id=?1", nativeQuery=true)
	java.util.List<com.StoreX.persistence.entity.ZamowienieEntities.PozycjaZamowienia> findAllForZamowienie(Long id);

	/**
	 * 
	 * @param id
	 * @param ilosc
	 */
	@Modifying
	@Query(value="update pozycja_zamowienia set zrealizowano = ?2 where id = ?1", nativeQuery=true)
	int realizacjaPozycjiZmowienia(Long id, double ilosc);

	/**
	 * 
	 * @param id
	 */
	@Query(value="select  zamowienie.dtype from pozycja_Zamowienia join zamowienie on zamowienie.id = pozycja_zamowienia.zamowienie_id where pozycja_zamowienia.id = ?1", nativeQuery=true)
	String getType(Long id);

}