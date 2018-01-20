package com.StoreX.service.impl.HelperServicesImpl;

import com.StoreX.persistence.entity.TowarEntities.Kategoria;
import com.StoreX.persistence.repository.TowarRepository.KategoriaRepository;
import com.StoreX.service.HelperServices.KategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KategoriaServiceImpl implements KategoriaService {

    @Autowired
    KategoriaRepository kategoriaRepository;
    @Override
    public void add(Kategoria kategoria) {
        getKategoriaRepository().save(kategoria);
    }

    public KategoriaRepository getKategoriaRepository() {
        return kategoriaRepository;
    }
}
