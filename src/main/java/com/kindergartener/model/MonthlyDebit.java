package com.kindergartener.model;

import java.io.Serializable;

/**
 * Created by Hp on 5/16/2017.
 */

public class MonthlyDebit implements Serializable {

    private int month;

    private double debit;

    private double paid;

    private double carriedDebit;

    private double carriedPaid;

    public MonthlyDebit() {}

    public MonthlyDebit(int month, double debit, double paid, double carriedDebit, double carriedPaid) {
        this.month = month;
        this.debit = debit;
        this.paid = paid;
        this.carriedDebit = carriedDebit;
        this.carriedPaid = carriedPaid;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public double getDebit() {
        return debit;
    }

    public void setDebit(double debit) {
        this.debit = debit;
    }

    public double getPaid() {
        return paid;
    }

    public void setPaid(double paid) {
        this.paid = paid;
    }

    public double getCarriedDebit() {
        return carriedDebit;
    }

    public void setCarriedDebit(double carriedDebit) {
        this.carriedDebit = carriedDebit;
    }

    public double getCarriedPaid() {
        return carriedPaid;
    }

    public void setCarriedPaid(double carriedPaid) {
        this.carriedPaid = carriedPaid;
    }
}
