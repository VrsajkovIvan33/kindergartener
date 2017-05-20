package com.kindergartener.repository;

import com.kindergartener.model.Institution;
import com.kindergartener.model.User;
import com.kindergartener.model.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Hp on 4/30/2017.
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findById(Long id);

    List<User> findByUsername(String username);

    List<User> findByInstitution(Institution institution);

    List<User> findByInstitutionAndUserType(Institution institution, UserType userType);

}
