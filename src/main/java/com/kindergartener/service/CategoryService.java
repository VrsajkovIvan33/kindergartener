package com.kindergartener.service;

import com.kindergartener.model.Category;

import java.util.List;

/**
 * Created by Hp on 5/4/2017.
 */

public interface CategoryService {

    Category findById(Long id);

    List<Category> findByParameters(int parentNumber, int familyMembersNumber, int childrenNumber, int orderNumber,
                                    Boolean specialNeeds);

    List<Category> findByIsDefault(Boolean isDefault);

    Category save(Category category);
}
