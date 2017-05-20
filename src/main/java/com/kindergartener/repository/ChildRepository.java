package com.kindergartener.repository;

import com.kindergartener.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Hp on 5/4/2017.
 */

@Repository
public interface ChildRepository extends JpaRepository<Child, Long> {

    Child findById(Long id);

    List<Child> findByInstitution(Institution institution);

    List<Child> findBySupportedGroup(SupportedGroup supportedGroup);

    @Query("SELECT c FROM Child c WHERE c.supportedGroup.group = ?1")
    List<Child> findByGroup(Group group);

    List<Child> findByParent1AndParent2(User parent1, User parent2);
}
