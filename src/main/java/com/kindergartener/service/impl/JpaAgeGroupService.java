package com.kindergartener.service.impl;

import com.kindergartener.model.AgeGroup;
import com.kindergartener.repository.AgeGroupRepository;
import com.kindergartener.service.AgeGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Hp on 5/2/2017.
 */

@Service
@Transactional
public class JpaAgeGroupService implements AgeGroupService {

    @Autowired
    private AgeGroupRepository ageGroupRepository;

    @Override
    public List<AgeGroup> findAll() {
        return ageGroupRepository.findAll();
    }

    @Override
    public AgeGroup findById(Long id) {
        return ageGroupRepository.findById(id);
    }

    @Override
    public List<AgeGroup> findByName(String name) {
        return ageGroupRepository.findByName(name);
    }

    @Override
    public List<AgeGroup> findByAge(int age) {
        return ageGroupRepository.findByAge(age);
    }

    @Override
    public AgeGroup save(AgeGroup ageGroup) {
        return ageGroupRepository.save(ageGroup);
    }
}
