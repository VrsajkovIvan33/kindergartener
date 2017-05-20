package com.kindergartener.controller;

import com.kindergartener.model.Teacher;
import com.kindergartener.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Hp on 5/12/2017.
 */

@RestController
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @RequestMapping(
            value = "/teacher/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Teacher> getTeacher(@PathVariable(name = "id") Long id) {

        Teacher teacher = teacherService.findById(id);
        return new ResponseEntity<Teacher>(teacher, HttpStatus.OK);
    }
}
