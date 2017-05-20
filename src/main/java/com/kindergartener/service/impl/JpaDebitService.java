package com.kindergartener.service.impl;

import com.kindergartener.model.*;
import com.kindergartener.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Hp on 5/16/2017.
 */

@Service
@Transactional
public class JpaDebitService implements DebitService {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private AttendanceService attendanceService;

    @Autowired
    private PricelistService pricelistService;

    @Override
    public MonthlyDebit calculateMonthlyDebit(Child child, int month, int year, double percentage, double fullPrice) {

        MonthlyDebit monthlyDebit = new MonthlyDebit();

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        Date startDate = calendar.getTime();
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        Date endDate = calendar.getTime();

        Long wasPresentAtAll = attendanceService.countByChildAndDateBetween(child, startDate, endDate);

        // don't calculate anything if the child was not present at all during the specified month
        if (wasPresentAtAll == 0) {
            return null;
        }

        Long justifiedAbsencesCount = attendanceService.countByChildAndDateBetweenAndAbsenceJustified(child, startDate,
                endDate);

        List<Payment> payments = paymentService.findByChildAndMonthAndYear(child, month + 1, year);

        double tempPaid = 0;
        for (Payment payment : payments) {
            tempPaid += payment.getAmount();
        }

        monthlyDebit.setDebit(percentage * (fullPrice/2 + ((22 - justifiedAbsencesCount.doubleValue()) / 22) * fullPrice/2));

        monthlyDebit.setPaid(tempPaid);

        return monthlyDebit;
    }

    @Override
    public TotalDebit calculateTotalDebit(Child child, int year) {

        // can't calculate anything if the child isn't assigned to any group
        if (child.getSupportedGroup() == null) {
            return null;
        }

        TotalDebit debit = new TotalDebit();
        debit.setChildName(child.getName());
        debit.setChildSurname(child.getSurname());

        double fullPrice;
        if (child.getSupportedGroup().getGroup().getWorkType().getName().equals("Obdaniste")) {
            fullPrice = child.getInstitution().getFullPrice();
        }
        else {
            fullPrice = child.getInstitution().getPartialPrice();
        }

        List<Pricelist> pricelists = pricelistService.findCurrentByCategoryAndInstitution(child.getCategory(),
                child.getInstitution());
        // can't determine which pricelist to use
        if (pricelists.size() != 1) {
            return null;
        }
        double percentage = pricelists.get(0).getPercentage()/100;

        double totalDebit = 0;
        double totalPaid = 0;

        // calculate the debit for every single month and collect the result if the child attended classes during the
        // specified month
        for (int month = 0; month < 12; month++) {
            MonthlyDebit monthlyDebit = calculateMonthlyDebit(child, month, year, percentage, fullPrice);
            if (monthlyDebit != null) {
                monthlyDebit.setCarriedDebit(totalDebit);
                monthlyDebit.setCarriedPaid(totalPaid);
                totalDebit += monthlyDebit.getDebit();
                totalPaid += monthlyDebit.getPaid();
                monthlyDebit.setMonth(month + 1);
                debit.getDebits().add(monthlyDebit);
            }
        }

        debit.setTotalDebit(totalDebit);
        debit.setTotalPaid(totalPaid);

        return debit;
    }
}
