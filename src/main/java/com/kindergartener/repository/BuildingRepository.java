package com.kindergartener.repository;

import com.kindergartener.model.Building;
import com.kindergartener.model.Institution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Hp on 5/2/2017.
 */

@Repository
public interface BuildingRepository extends JpaRepository<Building, Long> {

    Building findById(Long id);

    List<Building> findByInstitution(Institution institution);

}
