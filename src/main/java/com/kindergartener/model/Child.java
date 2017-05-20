package com.kindergartener.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Hp on 4/28/2017.
 */

@Entity
@Table(name = "child")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Child implements Serializable {

    @Id
    @SequenceGenerator(name = "child_cid_seq",
            sequenceName = "child_cid_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "child_cid_seq")
    @Column(name = "cid", updatable = false)
    private Long id;

    @Column(name = "cname")
    private String name;

    @Column(name = "csname")
    private String surname;

    @Column(name = "cdateob")
    private Date dateOfBirth;

    @Column(name = "cplaceob")
    private String placeOfBirth;

    @Column(name = "cjmgb")
    private String jmbg;

    @Column(name = "caddress")
    private String address;

    @Column(name = "cphono")
    private String phoneNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ctgid", referencedColumnName = "ctgid", nullable = false)
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "par1id", referencedColumnName = "uid", nullable = false)
    private User parent1;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "par2id", referencedColumnName = "uid")
    private User parent2;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agid", referencedColumnName = "agid", nullable = false)
    private AgeGroup ageGroup;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lid", referencedColumnName = "lid")
    private Language nativeLanguage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sgid", referencedColumnName = "sgid")
    private SupportedGroup supportedGroup;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "iid", referencedColumnName = "iid")
    private Institution institution;

    @Version
    private int version;

    public Child() {}

    public Child(String name, String surname, Date dateOfBirth, String placeOfBirth, String jmbg, String address, String phoneNumber, Category category, User parent1, User parent2, AgeGroup ageGroup, Language nativeLanguage, SupportedGroup supportedGroup, Institution institution, int version) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.placeOfBirth = placeOfBirth;
        this.jmbg = jmbg;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.category = category;
        this.parent1 = parent1;
        this.parent2 = parent2;
        this.ageGroup = ageGroup;
        this.nativeLanguage = nativeLanguage;
        this.supportedGroup = supportedGroup;
        this.institution = institution;
        this.version = version;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        if (dateOfBirth.before(new Date())) {
            this.dateOfBirth = dateOfBirth;
        }
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        if (jmbg.length() == 13) {
            this.jmbg = jmbg;
        }
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public User getParent1() {
        return parent1;
    }

    public void setParent1(User parent1) {
        if (parent1.getUserType() == UserType.PARENT) {
            this.parent1 = parent1;
        }
    }

    public User getParent2() {
        return parent2;
    }

    public void setParent2(User parent2) {
        if (parent2 != null) {
            if (parent2.getUserType() == UserType.PARENT) {
                this.parent2 = parent2;
            }
        }
        else {
            this.parent2 = parent2;
        }
    }

    public AgeGroup getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(AgeGroup ageGroup) {
        this.ageGroup = ageGroup;
    }

    public Language getNativeLanguage() {
        return nativeLanguage;
    }

    public void setNativeLanguage(Language nativeLanguage) {
        this.nativeLanguage = nativeLanguage;
    }

    public SupportedGroup getSupportedGroup() {
        return supportedGroup;
    }

    public void setSupportedGroup(SupportedGroup supportedGroup) {
        if (supportedGroup != null) {
            if (supportedGroup.getAgeGroup().getId() == this.ageGroup.getId()) {
                this.supportedGroup = supportedGroup;
            }
        }
        else {
            this.supportedGroup = supportedGroup;
        }
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
