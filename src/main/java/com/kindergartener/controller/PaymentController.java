package com.kindergartener.controller;

import com.kindergartener.model.Payment;
import com.kindergartener.service.ChildService;
import com.kindergartener.service.InstitutionService;
import com.kindergartener.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Hp on 5/16/2017.
 */

@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private ChildService childService;

    @Autowired
    private InstitutionService institutionService;

    @RequestMapping(
            value = "/paymentsByChild/{cid}/{month}/{year}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<Payment>> getPaymentsByChild(@PathVariable(name = "cid") Long childId,
                                                           @PathVariable(name = "month") int month,
                                                           @PathVariable(name = "year") int year) {
        List<Payment> payments = null;
        if (month == 0 && year == 0) {
            payments = paymentService.findByChild(childService.findById(childId));
        }
        else if (month == 0) {
            payments = paymentService.findByYearAndChild(year, childService.findById(childId));
        }
        else if (year == 0) {
            payments = paymentService.findByMonthAndChild(month, childService.findById(childId));
        }
        else {
            payments = paymentService.findByChildAndMonthAndYear(childService.findById(childId), month, year);
        }
        return new ResponseEntity<List<Payment>>(payments, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/paymentsByInstitution/{iid}/{month}/{year}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<Payment>> getPaymentsByInstitution(@PathVariable(name = "iid") Long institutionId,
                                            @PathVariable(name = "month") int month,
                                            @PathVariable(name = "year") int year) {
        List<Payment> payments = null;
        if (month == 0 && year == 0) {
            payments = paymentService.findByInstitution(institutionService.findById(institutionId));
        }
        else if (month == 0) {
            payments = paymentService.findByYearAndInstitution(year, institutionService.findById(institutionId));
        }
        else if (year == 0) {
            payments = paymentService.findByMonthAndInstitution(month, institutionService.findById(institutionId));
        }
        else {
            payments = paymentService.findByMonthAndYearAndInstitution(month, year, institutionService.findById(institutionId));
        }
        return new ResponseEntity<List<Payment>>(payments, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/payment",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Payment> addPayment(@RequestBody Payment newPayment) {

        Payment payment = new Payment();
        payment.setMonth(newPayment.getMonth());
        payment.setYear(newPayment.getYear());
        payment.setChild(newPayment.getChild());
        payment.setAmount(newPayment.getAmount());
        payment.setDate(newPayment.getDate());
        payment.setPaymentType(newPayment.getPaymentType());
        Payment savedPayment = paymentService.save(payment);
        return new ResponseEntity<Payment>(savedPayment, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/payment",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Payment> updatePayment(@RequestBody Payment updatedPayment) {

        Payment payment = paymentService.findById(updatedPayment.getId());
        payment.setMonth(updatedPayment.getMonth());
        payment.setYear(updatedPayment.getYear());
        payment.setChild(updatedPayment.getChild());
        payment.setAmount(updatedPayment.getAmount());
        payment.setDate(updatedPayment.getDate());
        payment.setPaymentType(updatedPayment.getPaymentType());
        Payment savedPayment = paymentService.save(payment);
        return new ResponseEntity<Payment>(savedPayment, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/payment/{id}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Payment> removePayment(@PathVariable(name = "id") Long paymentId) {

        Payment removedPayment = paymentService.findById(paymentId);
        if (removedPayment != null) {
            paymentService.remove(paymentId);
            return new ResponseEntity<Payment>(removedPayment, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

}
