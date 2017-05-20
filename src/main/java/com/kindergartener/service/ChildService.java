package com.kindergartener.service;

import com.kindergartener.model.Child;
import com.kindergartener.model.Group;
import com.kindergartener.model.Institution;
import com.kindergartener.model.SupportedGroup;

import java.util.List;

/**
 * Created by Hp on 5/4/2017.
 */

public interface ChildService {

    Child findById(Long id);

    List<Child> findByInstitution(Institution institution);

    List<Child> findBySupportedGroup(SupportedGroup supportedGroup);

    List<Child> findByGroup(Group group);

    Child save(Child child);

    void remove(Long id);
}
