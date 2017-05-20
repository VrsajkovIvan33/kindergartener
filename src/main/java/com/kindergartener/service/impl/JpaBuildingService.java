package com.kindergartener.service.impl;

import com.kindergartener.model.Building;
import com.kindergartener.model.Institution;
import com.kindergartener.repository.BuildingRepository;
import com.kindergartener.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Hp on 5/2/2017.
 */

@Service
@Transactional
public class JpaBuildingService implements BuildingService {

    @Autowired
    private BuildingRepository buildingRepository;

    @Override
    public Building findById(Long id) {
        return buildingRepository.findById(id);
    }

    @Override
    public List<Building> findByInstitution(Institution institution) {
        return buildingRepository.findByInstitution(institution);
    }

    @Override
    public Building save(Building building) {
        return buildingRepository.save(building);
    }
}
