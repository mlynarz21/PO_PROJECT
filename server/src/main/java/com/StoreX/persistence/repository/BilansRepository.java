package com.StoreX.persistence.repository;
import com.StoreX.persistence.entity.Bilans;

import java.util.List;

public interface BilansRepository {

    public List<String> getMissingBalanceDates();

    public Bilans createBilans(Bilans artifact);

    public List<Bilans> findAllBilans();
}
