package com.kindergartener.service;

import com.kindergartener.model.*;

import java.util.List;

/**
 * Created by Hp on 5/2/2017.
 */

public interface GroupService {

    Group findById(Long id);

    List<Group> findByBuilding(Building building);

    List<Group> findByInstitution(Institution institution);

    List<Group> findByShiftAndInstitution(Shift shift, Institution institution);

    List<Group> findByWorkTypeAndInstitution(WorkType workType, Institution institution);

    Group save(Group group);
}
