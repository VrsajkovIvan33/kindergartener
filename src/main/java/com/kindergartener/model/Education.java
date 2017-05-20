package com.kindergartener.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Hp on 5/2/2017.
 */

@Entity
@Table(name = "education")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Education implements Serializable {

    @Id
    @SequenceGenerator(name = "education_eid_seq",
            sequenceName = "education_eid_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "education_eid_seq")
    @Column(name = "eid", updatable=false)
    private long id;

    @Column(name = "ename")
    private String name;

    @Version
    private int version;

    public Education() {}

    public Education(String name, int version) {
        this.name = name;
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

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
