package com.kindergartener.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * Created by Hp on 5/2/2017.
 */

@Entity
@Table(name = "agegroup")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class AgeGroup {

    @Id
    @SequenceGenerator(name = "agegroup_agid_seq",
            sequenceName = "agegroup_agid_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "agegroup_agid_seq")
    @Column(name = "agid", updatable = false)
    private long id;

    @Column(name = "agname")
    private String name;

    @Column(name = "agage")
    private int age;

    @Version
    private int version;

    public AgeGroup() {}

    public AgeGroup(String name, int age, int version) {
        this.name = name;
        this.age = age;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
