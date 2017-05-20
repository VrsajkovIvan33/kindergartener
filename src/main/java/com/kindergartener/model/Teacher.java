package com.kindergartener.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * Created by Hp on 5/12/2017.
 */

@Entity
@Table
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Teacher extends User {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gid", referencedColumnName = "gid")
    private Group group;

    public Teacher() {}

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
