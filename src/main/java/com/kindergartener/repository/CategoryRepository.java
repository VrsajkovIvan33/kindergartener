package com.kindergartener.repository;

import com.kindergartener.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Hp on 5/4/2017.
 */

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findById(Long id);

    List<Category> findByParentNumberAndFamilyMembersNumberAndChildrenNumberAndOrderNumberAndSpecialNeeds(
            int parentNumber, int familyMembersNumber, int childrenNumber, int orderNumber, Boolean specialNeeds);

    List<Category> findByIsDefault(Boolean isDefault);
}
