package com.kindergartener.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Hp on 5/2/2017.
 */

@Entity
@Table(name = "shift")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Shift implements Serializable {

    @Id
    @SequenceGenerator(name = "shift_shid_seq",
            sequenceName = "shift_shid_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "shift_shid_seq")
    @Column(name = "shid", updatable=false)
    private long id;

    @Column(name = "shname")
    private String name;

    @Column(name = "shstart")
    private String startTime;

    @Column(name = "shend")
    private String endTime;

    @Version
    private int version;

    public Shift() {}

    public Shift(String name, String startTime, String endTime, int version) {
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
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

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
