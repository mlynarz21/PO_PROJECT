package com.StoreX.persistence.repository.ZamowienieRepository;

import org.springframework.data.jpa.repository.*;
import com.StoreX.persistence.entity.ZamowienieEntities.*;

public interface ZamowienieZakupuRepository extends JpaRepository<ZamowienieZakupu, Long> {

	/**
	 * todo query statements needs to be changed probably
	 * @param status
	 */
	@Query(value="select * from Zamowienie_zakupu natural join zamowienie where  status = ?1", nativeQuery=true)
	java.util.List<com.StoreX.persistence.entity.ZamowienieEntities.ZamowienieZakupu> findByStatus(String status);

	/**
	 * 
	 * @param ID
	 * @param statusWydania
	 */
	@Modifying
	@Query(value="update Zamowienie_Zakupu natural join zamowienie set status = ?2 where id = ?1", nativeQuery=true)
	void updateStatusZamowienia(Long ID, String statusWydania);

}