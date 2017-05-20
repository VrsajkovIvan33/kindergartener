package com.kindergartener.controller;

import com.kindergartener.model.Child;
import com.kindergartener.service.ChildService;
import com.kindergartener.service.GroupService;
import com.kindergartener.service.InstitutionService;
import com.kindergartener.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Hp on 5/5/2017.
 */

@RestController
public class ChildController {

    @Autowired
    private ChildService childService;

    @Autowired
    private InstitutionService institutionService;

    @Autowired
    private GroupService groupService;

    @Autowired
    private LanguageService languageService;

    @RequestMapping(
            value = "/childrenByInstitution/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Child>> getChildrenInInstitution(@PathVariable("id") Long institutionId){

        List<Child> children = childService.findByInstitution(institutionService.findById(institutionId));
        return new ResponseEntity<List<Child>>(children, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/childrenByGroup/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<Child>> getChildrenInGroup(@PathVariable(name = "id") Long groupId) {

        List<Child> children = childService.findByGroup(groupService.findById(groupId));
        return new ResponseEntity<List<Child>>(children, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/child",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Child> addChild(@RequestBody Child newChild) {

        Child child = new Child();
        child.setName(newChild.getName());
        child.setSurname(newChild.getSurname());
        child.setDateOfBirth(newChild.getDateOfBirth());
        child.setPlaceOfBirth(newChild.getPlaceOfBirth());
        child.setAddress(newChild.getAddress());
        child.setJmbg(newChild.getJmbg());
        child.setPhoneNumber(newChild.getPhoneNumber());
        child.setCategory(newChild.getCategory());
        child.setParent1(newChild.getParent1());
        child.setParent2(newChild.getParent2());
        child.setAgeGroup(newChild.getAgeGroup());
        child.setNativeLanguage(languageService.findById(newChild.getNativeLanguage().getId()));
        child.setSupportedGroup(newChild.getSupportedGroup());
        child.setInstitution(newChild.getInstitution());
        Child savedChild = childService.save(child);
        return new ResponseEntity<Child>(savedChild, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/child",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Child> updateChild(@RequestBody Child updatedChild) {

        Child child = childService.findById(updatedChild.getId());
        child.setName(updatedChild.getName());
        child.setSurname(updatedChild.getSurname());
        child.setDateOfBirth(updatedChild.getDateOfBirth());
        child.setPlaceOfBirth(updatedChild.getPlaceOfBirth());
        child.setAddress(updatedChild.getAddress());
        child.setJmbg(updatedChild.getJmbg());
        child.setPhoneNumber(updatedChild.getPhoneNumber());
        child.setCategory(updatedChild.getCategory());
        child.setParent1(updatedChild.getParent1());
        child.setParent2(updatedChild.getParent2());
        child.setAgeGroup(updatedChild.getAgeGroup());
        if (child.getNativeLanguage().getId() != updatedChild.getNativeLanguage().getId()) {
            child.setNativeLanguage(languageService.findById(updatedChild.getNativeLanguage().getId()));
        }
        child.setSupportedGroup(updatedChild.getSupportedGroup());
        child.setInstitution(updatedChild.getInstitution());
        Child savedChild = childService.save(child);
        return new ResponseEntity<Child>(savedChild, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/child/{id}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Child> removeChild(@PathVariable("id") Long id) {

        Child child = childService.findById(id);
        if (child != null) {
            childService.remove(id);
            return new ResponseEntity<Child>(child, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

}
