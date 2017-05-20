package com.kindergartener.service.impl;

import com.kindergartener.model.*;
import com.kindergartener.repository.GroupRepository;
import com.kindergartener.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Hp on 5/2/2017.
 */

@Service
@Transactional
public class JpaGroupService implements GroupService {

    @Autowired
    private GroupRepository groupRepository;

    @Override
    public Group findById(Long id) {
        return groupRepository.findById(id);
    }

    @Override
    public List<Group> findByBuilding(Building building) {
        return groupRepository.findByBuilding(building);
    }

    @Override
    public List<Group> findByInstitution(Institution institution) {
        return groupRepository.findByInstitution(institution);
    }

    @Override
    public List<Group> findByShiftAndInstitution(Shift shift, Institution institution) {
        return groupRepository.findByShiftAndInstitution(shift, institution);
    }

    @Override
    public List<Group> findByWorkTypeAndInstitution(WorkType workType, Institution institution) {
        return groupRepository.findByWorkTypeAndInstitution(workType, institution);
    }

    @Override
    public Group save(Group group) {
        return groupRepository.save(group);
    }
}
