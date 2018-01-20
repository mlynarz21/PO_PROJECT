package com.StoreX.persistence.repository.BilansRepository;

import org.springframework.data.jpa.repository.*;
import com.StoreX.persistence.entity.BilansEntities.*;

public interface BilansRepository extends JpaRepository<Bilans, Long> {

	@Query(value="select * from Bilans order by data_bilansu desc limit 1 ", nativeQuery=true)
	com.StoreX.persistence.entity.BilansEntities.Bilans findLastBilansByDate();

	/**
	 * 
	 * @param month
	 * @param year
	 */
	@Query(value="select count(*) from  bilans where year(data_bilansu) = ?2 and month(data_bilansu) = ?1", nativeQuery=true)
	int findBilansForMonthAndYear(int month, int year);

}