package com.kindergartener.repository;

import com.kindergartener.model.Child;
import com.kindergartener.model.Institution;
import com.kindergartener.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Hp on 5/16/2017.
 */

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

    Payment findById(Long id);

    List<Payment> findByChildAndMonthAndYear(Child child, int month, int year);

    List<Payment> findByChild(Child child);

    @Query("SELECT p FROM Payment p WHERE p.child.institution = ?1")
    List<Payment> findByInstitution(Institution institution);

    @Query("SELECT p FROM Payment p WHERE p.month = ?1 AND p.child.institution = ?2")
    List<Payment> findByMonthAndInstitution(int month, Institution institution);

    @Query("SELECT p FROM Payment p WHERE p.year = ?1 AND p.child.institution = ?2")
    List<Payment> findByYearAndInstitution(int year, Institution institution);

    @Query("SELECT p FROM Payment p WHERE p.month = ?1 AND p.year = ?2 AND p.child.institution = ?3")
    List<Payment> findByMonthAndYearAndInstitution(int month, int year, Institution institution);

    List<Payment> findByMonthAndChild(int month, Child child);

    List<Payment> findByYearAndChild(int year, Child child);

}
