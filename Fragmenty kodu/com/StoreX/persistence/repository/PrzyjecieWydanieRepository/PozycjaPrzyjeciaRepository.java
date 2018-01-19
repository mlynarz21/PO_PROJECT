package com.StoreX.persistence.repository.PrzyjecieWydanieRepository;

import org.springframework.data.jpa.repository.*;
import com.StoreX.persistence.entity.PrzyjecieWydanieEntities.*;

public interface PozycjaPrzyjeciaRepository extends JpaRepository<PozycjaPrzyjecia, Long> {

	/**
	 * 
	 * @param month
	 * @param year
	 */
	@Query(value="select p.* from pozycja_przyjecia p join przyjecie_zamowienia pz on p.przyjecie_zamowienia_id = pz.id  where month(pz.data) = ?1 and year(pz.data) = ?2 ", nativeQuery=true)
	java.util.List<com.StoreX.persistence.entity.PrzyjecieWydanieEntities.PozycjaPrzyjecia> findAllForMonthAndYear(int month, int year);

}