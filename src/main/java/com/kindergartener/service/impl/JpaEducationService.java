package com.kindergartener.service.impl;

import com.kindergartener.model.Education;
import com.kindergartener.repository.EducationRepository;
import com.kindergartener.service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Hp on 5/2/2017.
 */

@Service
@Transactional
public class JpaEducationService implements EducationService {

    @Autowired
    private EducationRepository educationRepository;

    @Override
    public List<Education> findAll() {
        return educationRepository.findAll();
    }

    @Override
    public Education findById(Long id) {
        return educationRepository.findById(id);
    }

    @Override
    public List<Education> findByName(String name) {
        return educationRepository.findByName(name);
    }

    @Override
    public Education save(Education education) {
        return educationRepository.save(education);
    }
}
