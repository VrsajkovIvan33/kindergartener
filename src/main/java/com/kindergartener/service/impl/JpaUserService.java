package com.kindergartener.service.impl;

import com.kindergartener.model.Institution;
import com.kindergartener.model.User;
import com.kindergartener.model.UserType;
import com.kindergartener.repository.UserRepository;
import com.kindergartener.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Hp on 4/30/2017.
 */

@Service
@Transactional
public class JpaUserService implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> findByInstitution(Institution institution) {
        return userRepository.findByInstitution(institution);
    }

    @Override
    public List<User> findByInsitutionAndUserType(Institution institution, UserType userType) {
        return userRepository.findByInstitutionAndUserType(institution, userType);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

}
