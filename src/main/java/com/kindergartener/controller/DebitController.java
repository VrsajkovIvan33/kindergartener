package com.kindergartener.controller;

import com.kindergartener.model.TotalDebit;
import com.kindergartener.service.ChildService;
import com.kindergartener.service.DebitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Hp on 5/17/2017.
 */

@RestController
public class DebitController {

    @Autowired
    private DebitService debitService;

    @Autowired
    private ChildService childService;

    @RequestMapping(
            value = "/debit/{cid}/{year}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<TotalDebit> calculateDebitForChild(@PathVariable("cid") Long childId, @PathVariable("year") int year) {

        TotalDebit totalDebit = debitService.calculateTotalDebit(childService.findById(childId), year);
        return new ResponseEntity<TotalDebit>(totalDebit, HttpStatus.OK);
    }

}
