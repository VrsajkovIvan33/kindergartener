package com.kindergartener.repository;

import com.kindergartener.model.Group;
import com.kindergartener.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Hp on 5/12/2017.
 */

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    Teacher findById(Long id);

    List<Teacher> findByGroup(Group group);

}
