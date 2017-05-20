package com.kindergartener.controller;

import com.kindergartener.model.LoginAttempt;
import com.kindergartener.model.User;
import com.kindergartener.model.UserType;
import com.kindergartener.repository.UserRepository;
import com.kindergartener.service.InstitutionService;
import com.kindergartener.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Hp on 4/30/2017.
 */

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private InstitutionService institutionService;

    @RequestMapping(
            value = "/login",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<User> login(@RequestBody LoginAttempt loginAttempt){

        List<User> foundUsers = userService.findByUsername(loginAttempt.getUsername());
        if (!foundUsers.isEmpty()) {
            for (User user : foundUsers) {
                if (user.getPassword().equals(loginAttempt.getPassword())) {
                    return new ResponseEntity<User>(user, HttpStatus.OK);
                }
            }
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        else {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

    }

    @RequestMapping(
            value = "/parents/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<User>> getAllParents(@PathVariable("id") Long institutionId) {

        List<User> parents = userService.findByInsitutionAndUserType(institutionService.findById(institutionId),
                UserType.PARENT);
        return new ResponseEntity<List<User>>(parents, HttpStatus.OK);
    }

}
