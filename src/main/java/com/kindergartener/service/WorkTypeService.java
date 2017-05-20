package com.kindergartener.service;

import com.kindergartener.model.WorkType;

import java.util.List;

/**
 * Created by Hp on 5/2/2017.
 */

public interface WorkTypeService {

    List<WorkType> findAll();

    WorkType findById(Long id);

    List<WorkType> findByName(String name);

    WorkType save(WorkType workType);
}
