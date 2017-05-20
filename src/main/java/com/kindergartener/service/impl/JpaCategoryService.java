package com.kindergartener.service.impl;

import com.kindergartener.model.Category;
import com.kindergartener.repository.CategoryRepository;
import com.kindergartener.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Hp on 5/4/2017.
 */

@Service
@Transactional
public class JpaCategoryService implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category findById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public List<Category> findByParameters(int parentNumber, int familyMembersNumber, int childrenNumber,
                                           int orderNumber, Boolean specialNeeds) {
        return categoryRepository.findByParentNumberAndFamilyMembersNumberAndChildrenNumberAndOrderNumberAndSpecialNeeds(
                parentNumber, familyMembersNumber, childrenNumber, orderNumber, specialNeeds);
    }

    @Override
    public List<Category> findByIsDefault(Boolean isDefault) {
        return categoryRepository.findByIsDefault(isDefault);
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }
}
