package com.kindergartener.service.impl;

import com.kindergartener.model.Institution;
import com.kindergartener.repository.InstitutionRepository;
import com.kindergartener.service.InstitutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Hp on 5/2/2017.
 */

@Service
@Transactional
public class JpaInstitutionService implements InstitutionService {

    @Autowired
    private InstitutionRepository institutionRepository;

    @Override
    public Institution findById(Long id) {
        return institutionRepository.findById(id);
    }

    @Override
    public List<Institution> findByName(String name) {
        return institutionRepository.findByName(name);
    }

    @Override
    public Institution save(Institution institution) {
        return institutionRepository.save(institution);
    }
}
