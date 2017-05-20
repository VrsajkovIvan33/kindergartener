package com.kindergartener.repository;

import com.kindergartener.model.WorkType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Hp on 5/2/2017.
 */

@Repository
public interface WorkTypeRepository extends JpaRepository<WorkType, Long> {

    WorkType findById(Long id);

    List<WorkType> findByName(String name);
}
