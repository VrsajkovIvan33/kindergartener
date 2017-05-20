package com.kindergartener.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * Created by Hp on 5/2/2017.
 */

@Entity
@Table(name = "supportedgroup")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class SupportedGroup {

    @Id
    @SequenceGenerator(name = "supportedgroup_sgid_seq",
            sequenceName = "supportedgroup_sgid_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "supportedgroup_sgid_seq")
    @Column(name = "sgid", updatable = false)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agid", referencedColumnName = "agid")
    private AgeGroup ageGroup;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gid", referencedColumnName = "gid")
    private Group group;

    @Version
    private int version;

    public SupportedGroup() {}

    public SupportedGroup(AgeGroup ageGroup, Group group, int version) {
        this.ageGroup = ageGroup;
        this.group = group;
        this.version = version;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public AgeGroup getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(AgeGroup ageGroup) {
        this.ageGroup = ageGroup;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
