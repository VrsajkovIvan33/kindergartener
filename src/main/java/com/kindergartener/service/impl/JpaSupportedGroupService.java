package com.kindergartener.service.impl;

import com.kindergartener.model.*;
import com.kindergartener.repository.SupportedGroupRepository;
import com.kindergartener.service.SupportedGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Hp on 5/2/2017.
 */

@Service
@Transactional
public class JpaSupportedGroupService implements SupportedGroupService {

    @Autowired
    private SupportedGroupRepository supportedGroupRepository;

    @Override
    public SupportedGroup findById(Long id) {
        return supportedGroupRepository.findById(id);
    }

    @Override
    public List<SupportedGroup> findByInstitution(Institution institution) {
        return supportedGroupRepository.findByInstitution(institution);
    }

    @Override
    public List<SupportedGroup> findByAgeGroupAndInstitutionAndLanguage(AgeGroup ageGroup, Institution institution,
                                                                        Language language) {
        return supportedGroupRepository.findByAgeGroupAndInstitutionAndLanguage(ageGroup, institution, language);
    }

    @Override
    public List<SupportedGroup> findByGroup(Group group) {
        return supportedGroupRepository.findByGroup(group);
    }

    @Override
    public SupportedGroup save(SupportedGroup supportedGroup) {
        return supportedGroupRepository.save(supportedGroup);
    }
}
