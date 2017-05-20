package com.kindergartener.service;

import com.kindergartener.model.Group;
import com.kindergartener.model.Teacher;

import java.util.List;

/**
 * Created by Hp on 5/12/2017.
 */

public interface TeacherService {

    Teacher findById(Long id);

    List<Teacher> findByGroup(Group group);

    Teacher save(Teacher teacher);

}
