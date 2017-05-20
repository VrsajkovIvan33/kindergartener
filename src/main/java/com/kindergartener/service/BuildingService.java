package com.kindergartener.service;

import com.kindergartener.model.Building;
import com.kindergartener.model.Institution;

import java.util.List;

/**
 * Created by Hp on 5/2/2017.
 */

public interface BuildingService {

    Building findById(Long id);

    List<Building> findByInstitution(Institution institution);

    Building save(Building building);
}
