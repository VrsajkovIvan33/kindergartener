package com.kindergartener.service;

import com.kindergartener.model.Institution;
import com.kindergartener.model.User;
import com.kindergartener.model.UserType;

import java.util.List;

/**
 * Created by Hp on 4/30/2017.
 */

public interface UserService {

    User findById(Long id);

    List<User> findByUsername(String username);

    List<User> findByInstitution(Institution institution);

    List<User> findByInsitutionAndUserType(Institution institution, UserType userType);

    User save(User user);

}
