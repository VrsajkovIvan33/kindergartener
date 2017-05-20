package com.kindergartener.repository;

import com.kindergartener.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Hp on 5/2/2017.
 */

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {

    Group findById(Long id);

    List<Group> findByBuilding(Building building);

    @Query("SELECT g FROM daycaregroup g WHERE g.building.institution = ?1")
    List<Group> findByInstitution(Institution institution);

    @Query("SELECT g FROM daycaregroup g WHERE g.shift = ?1 AND g.building.institution = ?2")
    List<Group> findByShiftAndInstitution(Shift shift, Institution institution);

    @Query("SELECT g FROM daycaregroup g WHERE g.workType = ?1 AND g.building.institution = ?2")
    List<Group> findByWorkTypeAndInstitution(WorkType workType, Institution institution);
}
