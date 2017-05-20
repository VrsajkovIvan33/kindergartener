package com.kindergartener.controller;

import com.kindergartener.model.Language;
import com.kindergartener.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Hp on 5/14/2017.
 */

@RestController
public class LanguageController {

    @Autowired
    private LanguageService languageService;

    @RequestMapping(
            value = "/languages",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<Language>> getLanguages() {

        List<Language> languages = languageService.findAll();
        return new ResponseEntity<List<Language>>(languages, HttpStatus.OK);
    }

}
