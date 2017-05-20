package com.kindergartener.service;

import com.kindergartener.model.Education;

import java.util.List;

/**
 * Created by Hp on 5/2/2017.
 */

public interface EducationService {

    List<Education> findAll();

    Education findById(Long id);

    List<Education> findByName(String name);

    Education save(Education education);
}
