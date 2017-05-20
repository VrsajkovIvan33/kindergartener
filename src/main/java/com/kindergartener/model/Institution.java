package com.kindergartener.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * Created by Hp on 4/30/2017.
 */

@Entity
@Table(name = "institution")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Institution {

    @Id
    @SequenceGenerator(name = "institution_iid_seq",
            sequenceName = "institution_iid_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "institution_iid_seq")
    @Column(name = "iid", updatable=false)
    private long id;

    @Column(name = "iname")
    private String name;

    @Column(name = "iaddr")
    private String address;

    @Column(name = "iphono")
    private String phoneNumber;

    @Column(name = "ifullp")
    private double fullPrice;

    @Column(name = "ipartp")
    private double partialPrice;

    @Version
    private int version;

    public Institution() {}

    public Institution(String name, String address, String phoneNumber, double fullPrice, double partialPrice, int version) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.fullPrice = fullPrice;
        this.partialPrice = partialPrice;
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

    public double getFullPrice() {
        return fullPrice;
    }

    public void setFullPrice(double fullPrice) {
        this.fullPrice = fullPrice;
    }

    public double getPartialPrice() {
        return partialPrice;
    }

    public void setPartialPrice(double partialPrice) {
        this.partialPrice = partialPrice;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
