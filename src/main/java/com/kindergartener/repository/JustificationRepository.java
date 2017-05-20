package com.kindergartener.repository;

import com.kindergartener.model.Justification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Hp on 5/13/2017.
 */

@Repository
public interface JustificationRepository extends JpaRepository<Justification, Long> {

    Justification findById(Long id);

}
