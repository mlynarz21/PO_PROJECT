package com.StoreX.persistence.repository.PrzyjecieWydanieRepository;

import org.springframework.data.jpa.repository.*;
import com.StoreX.persistence.entity.PrzyjecieWydanieEntities.*;

public interface PozycjaWydaniaRepository extends JpaRepository<PozycjaWydania, Long> {

	/**
	 * 
	 * @param month
	 * @param year
	 */
	@Query(value="select p.* from pozycja_wydania p join wydanie_zamowienia pz on p.wydanie_zamowienia_id = pz.id where month(pz.data) = ?1 and year(pz.data) = ?2 ", nativeQuery=true)
	java.util.List<com.StoreX.persistence.entity.PrzyjecieWydanieEntities.PozycjaWydania> findAllForMonthAndYear(int month, int year);

}