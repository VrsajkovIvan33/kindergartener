package com.kindergartener.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Hp on 5/14/2017.
 */

@Entity(name = "nativelanguage")
@Table(name = "nativelanguage")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Language implements Serializable {

    @Id
    @SequenceGenerator(name = "language_lid_seq",
            sequenceName = "language_lid_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "language_lid_seq")
    @Column(name = "lid", updatable = false)
    private long id;

    @Column(name = "lname")
    private String name;

    @ManyToMany(mappedBy = "languages")
    @JsonIgnore
    private List<Group> groups;

    @Version
    private int version;

    public Language() {}

    public Language(String name, List<Group> groups, int version) {
        this.name = name;
        this.groups = groups;
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

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
