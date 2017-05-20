package com.kindergartener.service;

import com.kindergartener.model.*;

import java.util.List;

/**
 * Created by Hp on 5/2/2017.
 */

public interface SupportedGroupService {

    SupportedGroup findById(Long id);

    List<SupportedGroup> findByInstitution(Institution institution);

    List<SupportedGroup> findByAgeGroupAndInstitutionAndLanguage(AgeGroup ageGroup, Institution institution,
                                                                 Language language);

    List<SupportedGroup> findByGroup(Group group);

    SupportedGroup save(SupportedGroup supportedGroup);
}
