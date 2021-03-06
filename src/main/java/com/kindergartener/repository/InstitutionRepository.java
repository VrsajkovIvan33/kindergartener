package com.kindergartener.repository;

import com.kindergartener.model.Institution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Hp on 5/2/2017.
 */

@Repository
public interface InstitutionRepository extends JpaRepository<Institution, Long> {

    Institution findById(Long id);

    List<Institution> findByName(String name);
}
