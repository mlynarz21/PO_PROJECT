package com.StoreX.persistence.repository;
//import com.StoreX.persistence.entity.Bilans;
//
//import java.util.List;
//
//public interface BilansRepository {
//
////    public List<String> getMissingBalanceDates();
////
////    public Bilans createBilans(Bilans artifact);
//
//   // public List<Bilans> findAllBilans();
//}

import org.springframework.data.jpa.repository.JpaRepository;
import com.StoreX.persistence.entity.Bilans;
import org.springframework.data.jpa.repository.Query;

/*
Auto generated CRUD operations
 */
public interface BilansRepository extends JpaRepository<Bilans, Long> {

    @Query(value = "select * from Bilans  order by data_bilansu limit 1 ", nativeQuery = true)
    Bilans findLastBilansByDate();
}
