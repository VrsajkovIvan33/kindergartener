package com.kindergartener.service.impl;

import com.kindergartener.model.Group;
import com.kindergartener.model.Teacher;
import com.kindergartener.repository.TeacherRepository;
import com.kindergartener.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Hp on 5/12/2017.
 */

@Service
@Transactional
public class JpaTeacherService implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public Teacher findById(Long id) {
        return teacherRepository.findById(id);
    }

    @Override
    public List<Teacher> findByGroup(Group group) {
        return teacherRepository.findByGroup(group);
    }

    @Override
    public Teacher save(Teacher teacher) {
        return teacherRepository.save(teacher);
    }
}
