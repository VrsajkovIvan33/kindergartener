package com.kindergartener.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Hp on 5/2/2017.
 */

@Entity
@Table(name = "building")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Building implements Serializable {

    @Id
    @SequenceGenerator(name = "building_bid_seq",
            sequenceName = "building_bid_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "building_bid_seq")
    @Column(name = "bid", updatable = false)
    private long id;

    @Column(name = "bname")
    private String name;

    @Column(name = "baddr")
    private String address;

    @Column(name = "bphono")
    private String phoneNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "iid", referencedColumnName = "iid")
    private Institution institution;

    @Version
    private int version;

    public Building() {}

    public Building(String name, String address, String phoneNumber, Institution institution, int version) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.institution = institution;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Institution getInstitution() {
        return institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
