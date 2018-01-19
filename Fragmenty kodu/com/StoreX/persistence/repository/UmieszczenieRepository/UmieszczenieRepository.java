package com.StoreX.persistence.repository.UmieszczenieRepository;

import org.springframework.data.jpa.repository.*;
import com.StoreX.persistence.entity.UmieszczenieEntities.*;

public interface UmieszczenieRepository extends JpaRepository<Umieszczenie, Long> {

	/**
	 * 
	 * @param id
	 */
	@Query(value="select * from Umieszczenie where towar_id=?1", nativeQuery=true)
	java.util.List<com.StoreX.persistence.entity.UmieszczenieEntities.Umieszczenie> findAllForTowar(Long id);

	/**
	 * 
	 * @param id
	 * @param ilosc
	 */
	@Modifying
	@Query(value="update umieszczenie set iloscwlokalizacji = ?2 where id = ?1", nativeQuery=true)
	int realizacjaPozycjiZmowienia(Long id, double ilosc);

}