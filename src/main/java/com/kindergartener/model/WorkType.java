package com.kindergartener.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * Created by Hp on 5/2/2017.
 */

@Entity
@Table(name = "worktype")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class WorkType {

    @Id
    @SequenceGenerator(name = "worktype_wtid_seq",
            sequenceName = "worktype_wtid_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "worktype_wtid_seq")
    @Column(name = "wtid")
    private long id;

    @Column(name = "wtname")
    private String name;

    @Column(name = "wthours")
    private int hoursOfDay;

    @Column(name = "wtmeals")
    private int numberOfMeals;

    @Version
    private int version;

    public WorkType() {}

    public WorkType(String name, int hoursOfDay, int numberOfMeals, int version) {
        this.name = name;
        this.hoursOfDay = hoursOfDay;
        this.numberOfMeals = numberOfMeals;
        this.version = version;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHoursOfDay() {
        return hoursOfDay;
    }

    public void setHoursOfDay(int hoursOfDay) {
        this.hoursOfDay = hoursOfDay;
    }

    public int getNumberOfMeals() {
        return numberOfMeals;
    }

    public void setNumberOfMeals(int numberOfMeals) {
        this.numberOfMeals = numberOfMeals;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
