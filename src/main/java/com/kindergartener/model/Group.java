package com.kindergartener.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Hp on 5/2/2017.
 */

@Entity(name = "daycaregroup")
@Table(name = "daycaregroup")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Group implements Serializable {

    @Id
    @SequenceGenerator(name = "daycaregroup_gid_seq",
            sequenceName = "daycaregroup_gid_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "daycaregroup_gid_seq")
    @Column(name = "gid", updatable=false)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bid", referencedColumnName = "bid")
    private Building building;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shid", referencedColumnName = "shid")
    private Shift shift;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "wtid", referencedColumnName = "wtid")
    private WorkType workType;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "grouplanguage", joinColumns = @JoinColumn(name = "gid", referencedColumnName = "gid"), inverseJoinColumns = @JoinColumn(name = "lid", referencedColumnName = "lid"))
    private List<Language> languages;

    @Version
    private int version;

    public Group() {}

    public Group(Building building, Shift shift, WorkType workType, List<Language> languages, int version) {
        this.building = building;
        this.shift = shift;
        this.workType = workType;
        this.languages = languages;
        this.version = version;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public Shift getShift() {
        return shift;
    }

    public void setShift(Shift shift) {
        this.shift = shift;
    }

    public WorkType getWorkType() {
        return workType;
    }

    public void setWorkType(WorkType workType) {
        this.workType = workType;
    }

    public List<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
