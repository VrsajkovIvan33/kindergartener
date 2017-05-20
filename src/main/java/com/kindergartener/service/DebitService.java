package com.kindergartener.service;

import com.kindergartener.model.Child;
import com.kindergartener.model.MonthlyDebit;
import com.kindergartener.model.TotalDebit;

/**
 * Created by Hp on 5/16/2017.
 */

public interface DebitService {

    MonthlyDebit calculateMonthlyDebit(Child child, int month, int year, double percentage, double fullPrice);

    TotalDebit calculateTotalDebit(Child child, int year);

}
