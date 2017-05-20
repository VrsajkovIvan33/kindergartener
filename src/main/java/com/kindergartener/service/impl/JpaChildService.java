package com.kindergartener.service.impl;

import com.kindergartener.model.Child;
import com.kindergartener.model.Group;
import com.kindergartener.model.Institution;
import com.kindergartener.model.SupportedGroup;
import com.kindergartener.repository.ChildRepository;
import com.kindergartener.service.ChildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Hp on 5/4/2017.
 */

@Service
@Transactional
public class JpaChildService implements ChildService{

    @Autowired
    private ChildRepository childRepository;

    @Override
    public Child findById(Long id) {
        return childRepository.findById(id);
    }

    @Override
    public List<Child> findByInstitution(Institution institution) {
        return childRepository.findByInstitution(institution);
    }

    @Override
    public List<Child> findBySupportedGroup(SupportedGroup supportedGroup) {
        return childRepository.findBySupportedGroup(supportedGroup);
    }

    @Override
    public List<Child> findByGroup(Group group) {
        return childRepository.findByGroup(group);
    }

    @Override
    public Child save(Child newChild) {

        if (!newChild.getCategory().getDefault()) {
            int olderCount = 0;
            List<Child> children = childRepository.findByParent1AndParent2(newChild.getParent1(), newChild.getParent2());
            // check if the category parent number doesn't match the actual parent number
            if (newChild.getCategory().getParentNumber() == 1 && newChild.getParent2() != null) {
                return null;
            }
            // check if there are more children enrolled from the family than the number stated in the category
            if (newChild.getCategory().getChildrenNumber() < children.size()) {
                return null;
            }
            // count the older children of the same family and validate the order number specified in the category
            for (Child child : children) {
                if (child.getDateOfBirth().before(newChild.getDateOfBirth())) {
                    olderCount++;
                }
            }
            if (olderCount > newChild.getCategory().getOrderNumber()) {
                return null;
            }
        }

        return childRepository.save(newChild);
    }

    @Override
    public void remove(Long id) {
        childRepository.delete(id);
    }
}
