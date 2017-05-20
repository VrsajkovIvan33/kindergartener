package com.kindergartener.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hp on 5/16/2017.
 */

public class TotalDebit implements Serializable {

    private double totalDebit;

    private double totalPaid;

    private String childName;

    private String childSurname;

    private List<MonthlyDebit> debits;

    public TotalDebit() {
        this.debits = new ArrayList<>();
    }

    public TotalDebit(double totalDebit, double totalPaid, String childName, String childSurname, List<MonthlyDebit> debits) {
        this.totalDebit = totalDebit;
        this.totalPaid = totalPaid;
        this.childName = childName;
        this.childSurname = childSurname;
        this.debits = debits;
    }

    public double getTotalDebit() {
        return totalDebit;
    }

    public void setTotalDebit(double totalDebit) {
        this.totalDebit = totalDebit;
    }

    public double getTotalPaid() {
        return totalPaid;
    }

    public void setTotalPaid(double totalPaid) {
        this.totalPaid = totalPaid;
    }

    public String getChildName() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
    }

    public String getChildSurname() {
        return childSurname;
    }

    public void setChildSurname(String childSurname) {
        this.childSurname = childSurname;
    }

    public List<MonthlyDebit> getDebits() {
        return debits;
    }

    public void setDebits(List<MonthlyDebit> debits) {
        this.debits = debits;
    }
}
