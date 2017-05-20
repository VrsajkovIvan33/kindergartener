package com.kindergartener.service;

import com.kindergartener.model.Child;
import com.kindergartener.model.Institution;
import com.kindergartener.model.Payment;

import java.util.List;

/**
 * Created by Hp on 5/16/2017.
 */

public interface PaymentService {

    Payment findById(Long id);

    List<Payment> findByChildAndMonthAndYear(Child child, int month, int year);

    List<Payment> findByChild(Child child);

    List<Payment> findByInstitution(Institution institution);

    List<Payment> findByMonthAndInstitution(int month, Institution institution);

    List<Payment> findByYearAndInstitution(int year, Institution institution);

    List<Payment> findByMonthAndYearAndInstitution(int month, int year, Institution institution);

    List<Payment> findByMonthAndChild(int month, Child child);

    List<Payment> findByYearAndChild(int year, Child child);

    Payment save(Payment payment);

    void remove(Long id);

}
