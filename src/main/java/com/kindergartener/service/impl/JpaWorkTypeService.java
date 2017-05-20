package com.kindergartener.service.impl;

import com.kindergartener.model.WorkType;
import com.kindergartener.repository.WorkTypeRepository;
import com.kindergartener.service.WorkTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Hp on 5/2/2017.
 */

@Service
@Transactional
public class JpaWorkTypeService implements WorkTypeService {

    @Autowired
    private WorkTypeRepository workTypeRepository;

    @Override
    public List<WorkType> findAll() {
        return workTypeRepository.findAll();
    }

    @Override
    public WorkType findById(Long id) {
        return workTypeRepository.findById(id);
    }

    @Override
    public List<WorkType> findByName(String name) {
        return workTypeRepository.findByName(name);
    }

    @Override
    public WorkType save(WorkType workType) {
        return workTypeRepository.save(workType);
    }
}
