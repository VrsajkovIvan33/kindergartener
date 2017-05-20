package com.kindergartener.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Hp on 5/8/2017.
 */

@Entity
@Table
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Pricelist implements Serializable {

    @Id
    @SequenceGenerator(name = "pricelist_pid_seq",
            sequenceName = "pricelist_pid_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "pricelist_pid_seq")
    @Column(name = "pid", updatable=false)
    private Long id;

    @Column(name = "pfdate")
    private Date fromDate;

    @Column(name = "pudate")
    private Date untilDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ctgid", referencedColumnName = "ctgid")
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "iid", referencedColumnName = "iid")
    private Institution institution;

    @Column(name = "pperc")
    private double percentage;

    @Version
    private int version;

    public Pricelist() {}

    public Pricelist(Date fromDate, Date untilDate, Category category, Institution institution, double percentage, int version) {
        this.fromDate = fromDate;
        this.untilDate = untilDate;
        this.category = category;
        this.institution = institution;
        this.percentage = percentage;
        this.version = version;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getUntilDate() {
        return untilDate;
    }

    public void setUntilDate(Date untilDate) {
        this.untilDate = untilDate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Institution getInstitution() {
        return institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
