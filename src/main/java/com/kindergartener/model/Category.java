package com.kindergartener.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Hp on 5/4/2017.
 */

@Entity
@Table(name = "category")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Category {

    @Id
    @SequenceGenerator(name = "category_ctgid_seq",
            sequenceName = "category_ctgid_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "category_ctgid_seq")
    @Column(name = "ctgid", updatable = false)
    private long id;

    @Column(name = "ctgparno")
    private int parentNumber;

    @Column(name = "ctgfammemno")
    private int familyMembersNumber;

    @Column(name = "ctgchno")
    private int childrenNumber;

    @Column(name = "ctgorno")
    private int orderNumber;

    @Column(name = "ctgspecnd")
    private Boolean specialNeeds;

    @Column(name = "ctgdef")
    private Boolean isDefault;

    @Version
    private int version;

    public Category() {}

    public Category(int parentNumber, int familyMembersNumber, int childrenNumber, int orderNumber, Boolean specialNeeds, Boolean isDefault, int version) {
        this.parentNumber = parentNumber;
        this.familyMembersNumber = familyMembersNumber;
        this.childrenNumber = childrenNumber;
        this.orderNumber = orderNumber;
        this.specialNeeds = specialNeeds;
        this.isDefault = isDefault;
        this.version = version;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getParentNumber() {
        return parentNumber;
    }

    public void setParentNumber(int parentNumber) {
        if (parentNumber >= 0 && parentNumber <= 2) {
            this.parentNumber = parentNumber;
        }
    }

    public int getFamilyMembersNumber() {
        return familyMembersNumber;
    }

    public void setFamilyMembersNumber(int familyMembersNumber) {
        if (familyMembersNumber >= 0) {
            this.familyMembersNumber = familyMembersNumber;
        }
    }

    public int getChildrenNumber() {
        return childrenNumber;
    }

    public void setChildrenNumber(int childrenNumber) {
        if (childrenNumber >= 1) {
            this.childrenNumber = childrenNumber;
        }
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        if (orderNumber >= 1 && orderNumber <= this.childrenNumber) {
            this.orderNumber = orderNumber;
        }
    }

    public Boolean getSpecialNeeds() {
        return specialNeeds;
    }

    public void setSpecialNeeds(Boolean specialNeeds) {
        this.specialNeeds = specialNeeds;
    }

    public Boolean getDefault() {
        return isDefault;
    }

    public void setDefault(Boolean aDefault) {
        isDefault = aDefault;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
