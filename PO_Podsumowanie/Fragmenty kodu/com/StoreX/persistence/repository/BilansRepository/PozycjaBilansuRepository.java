package com.StoreX.persistence.repository.BilansRepository;

import org.springframework.data.jpa.repository.*;
import com.StoreX.persistence.entity.BilansEntities.*;

public interface PozycjaBilansuRepository extends JpaRepository<PozycjaBilansu, Long> {

	/**
	 * 
	 * @param month
	 * @param year
	 */
	@Query(value="select * from pozycja_bilansu", nativeQuery=true)
	java.util.List<com.StoreX.persistence.entity.BilansEntities.PozycjaBilansu> findAllforMonthAndYear(int month, int year);

	/**
	 * 
	 * @param bilansId
	 */
	@Query(value="select * from pozycja_bilansu where bilans_id = ?1", nativeQuery=true)
	java.util.List<com.StoreX.persistence.entity.BilansEntities.PozycjaBilansu> findAllForBilans(Long bilansId);

}