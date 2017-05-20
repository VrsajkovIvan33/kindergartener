package com.kindergartener.service.impl;

import com.kindergartener.model.Child;
import com.kindergartener.model.Institution;
import com.kindergartener.model.Payment;
import com.kindergartener.repository.PaymentRepository;
import com.kindergartener.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Hp on 5/16/2017.
 */

@Service
@Transactional
public class JpaPaymentService implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public Payment findById(Long id) {
        return paymentRepository.findById(id);
    }

    @Override
    public List<Payment> findByChildAndMonthAndYear(Child child, int month, int year) {
        return paymentRepository.findByChildAndMonthAndYear(child, month, year);
    }

    @Override
    public List<Payment> findByChild(Child child) {
        return paymentRepository.findByChild(child);
    }

    @Override
    public List<Payment> findByInstitution(Institution institution) {
        return paymentRepository.findByInstitution(institution);
    }

    @Override
    public List<Payment> findByMonthAndInstitution(int month, Institution institution) {
        return paymentRepository.findByMonthAndInstitution(month, institution);
    }

    @Override
    public List<Payment> findByYearAndInstitution(int year, Institution institution) {
        return paymentRepository.findByYearAndInstitution(year, institution);
    }

    @Override
    public List<Payment> findByMonthAndYearAndInstitution(int month, int year, Institution institution) {
        return paymentRepository.findByMonthAndYearAndInstitution(month, year, institution);
    }

    @Override
    public List<Payment> findByMonthAndChild(int month, Child child) {
        return paymentRepository.findByMonthAndChild(month, child);
    }

    @Override
    public List<Payment> findByYearAndChild(int year, Child child) {
        return paymentRepository.findByYearAndChild(year, child);
    }

    @Override
    public Payment save(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public void remove(Long id) {
        paymentRepository.delete(id);
    }
}
