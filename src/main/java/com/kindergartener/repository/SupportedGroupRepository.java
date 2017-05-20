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
public interface SupportedGroupRepository extends JpaRepository<SupportedGroup, Long> {

    SupportedGroup findById(Long id);

    @Query("SELECT sg FROM SupportedGroup sg WHERE sg.group.building.institution = ?1")
    List<SupportedGroup> findByInstitution(Institution institution);

    @Query("SELECT sg FROM SupportedGroup sg WHERE sg.ageGroup = ?1 AND sg.group.building.institution = ?2 AND ?3 MEMBER sg.group.languages")
    List<SupportedGroup> findByAgeGroupAndInstitutionAndLanguage(AgeGroup ageGroup, Institution institution, Language language);

    List<SupportedGroup> findByGroup(Group group);
}
