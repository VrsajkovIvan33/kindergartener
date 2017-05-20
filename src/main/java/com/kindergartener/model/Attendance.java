package com.kindergartener.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Hp on 5/12/2017.
 */

@Entity
@Table
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Attendance implements Serializable {

    @Id
    @SequenceGenerator(name = "attendance_aid_seq",
            sequenceName = "attendance_aid_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "attendance_aid_seq")
    @Column(name = "aid", updatable = false)
    private long id;

    @Column(name = "adate")
    private Date date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cid", referencedColumnName = "cid")
    private Child child;

    @Column(name = "awpr")
    private Boolean wasPresent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "jid", referencedColumnName = "jid")
    private Justification justification;

    @Version
    private int version;

    public Attendance() {}

    public Attendance(Date date, Child child, Boolean wasPresent, Justification justification, int version) {
        this.date = date;
        this.child = child;
        this.wasPresent = wasPresent;
        this.justification = justification;
        this.version = version;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Child getChild() {
        return child;
    }

    public void setChild(Child child) {
        this.child = child;
    }

    public Boolean getWasPresent() {
        return wasPresent;
    }

    public void setWasPresent(Boolean wasPresent) {
        this.wasPresent = wasPresent;
    }

    public Justification getJustification() {
        return justification;
    }

    public void setJustification(Justification justification) {
        this.justification = justification;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
