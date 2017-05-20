package com.kindergartener.controller;

import com.kindergartener.model.SupportedGroup;
import com.kindergartener.service.AgeGroupService;
import com.kindergartener.service.InstitutionService;
import com.kindergartener.service.LanguageService;
import com.kindergartener.service.SupportedGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Hp on 5/6/2017.
 */

@RestController
public class SupportedGroupController {

    @Autowired
    private SupportedGroupService supportedGroupService;

    @Autowired
    private AgeGroupService ageGroupService;

    @Autowired
    private InstitutionService institutionService;

    @Autowired
    private LanguageService languageService;

    @RequestMapping(
            value = "/supportedGroups/{agid}/{lid}/{iid}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<SupportedGroup>> getSuitableSupportedGroup(@PathVariable("agid") Long ageGroupId,
                                                                          @PathVariable("lid") Long languageId,
                                                                          @PathVariable("iid") Long institutionId) {
        List<SupportedGroup> supportedGroups = supportedGroupService.findByAgeGroupAndInstitutionAndLanguage(
                ageGroupService.findById(ageGroupId), institutionService.findById(institutionId),
                languageService.findById(languageId));
        return new ResponseEntity<List<SupportedGroup>>(supportedGroups, HttpStatus.OK);
    }

}
