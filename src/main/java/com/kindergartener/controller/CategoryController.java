package com.kindergartener.controller;

import com.kindergartener.model.Category;
import com.kindergartener.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Hp on 5/6/2017.
 */

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(
            value = "/category",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Category> findSuitableCategory(@RequestBody Category specifiedCategory) {

        List<Category> categories = categoryService.findByParameters(specifiedCategory.getParentNumber(),
                specifiedCategory.getFamilyMembersNumber(), specifiedCategory.getChildrenNumber(),
                specifiedCategory.getOrderNumber(), specifiedCategory.getSpecialNeeds());
        if (categories.size() == 1) {
            return new ResponseEntity<Category>(categories.get(0), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @RequestMapping(
            value = "/defaultCategory",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Category> getDefaultCategory() {

        List<Category> categories = categoryService.findByIsDefault(true);
        if (categories.size() == 1) {
            return new ResponseEntity<Category>(categories.get(0), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }
}
