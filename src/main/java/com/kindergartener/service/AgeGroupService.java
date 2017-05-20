package com.kindergartener.service;

import com.kindergartener.model.AgeGroup;

import java.util.List;

/**
 * Created by Hp on 5/2/2017.
 */

public interface AgeGroupService {

    List<AgeGroup> findAll();

    AgeGroup findById(Long id);

    List<AgeGroup> findByName(String name);

    List<AgeGroup> findByAge(int age);

    AgeGroup save(AgeGroup ageGroup);

}
