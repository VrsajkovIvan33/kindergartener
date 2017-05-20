package com.kindergartener.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Hp on 5/16/2017.
 */

@Table
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Payment implements Serializable {

    @Id
    @SequenceGenerator(name = "payment_pyid_seq",
            sequenceName = "payment_pyid_seq",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "payment_pyid_seq")
    private long id;

    @Column(name = "pymon")
    private int month;

    @Column(name = "pyyear")
    private int year;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cid", referencedColumnName = "cid")
    private Child child;

    @Column(name = "pytype")
    private PaymentType paymentType;

    @Column(name = "pyamo")
    private double amount;

    @Column(name = "pydate")
    private Date date;

    @Version
    private int version;

    public Payment() {}

    public Payment(int month, int year, Child child, PaymentType paymentType, double amount, Date date, int version) {
        this.month = month;
        this.year = year;
        this.child = child;
        this.paymentType = paymentType;
        this.amount = amount;
        this.date = date;
        this.version = version;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        if (month > 0 && month < 13) {
            this.month = month;
        }
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Child getChild() {
        return child;
    }

    public void setChild(Child child) {
        this.child = child;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
