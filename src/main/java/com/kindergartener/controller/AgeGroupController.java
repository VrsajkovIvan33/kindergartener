package com.kindergartener.controller;

import com.kindergartener.model.AgeGroup;
import com.kindergartener.service.AgeGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Hp on 5/6/2017.
 */

@RestController
public class AgeGroupController {

    @Autowired
    private AgeGroupService ageGroupService;

    @RequestMapping(
            value = "/ageGroups",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<AgeGroup>> getAgeGroups() {

        List<AgeGroup> ageGroups = ageGroupService.findAll();
        return new ResponseEntity<List<AgeGroup>>(ageGroups, HttpStatus.OK);
    }

}
