package com.kindergartener.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.kindergartener.model.Institution;

import javax.persistence.*;

/**
 * Created by Hp on 4/30/2017.
 */

@Entity(name = "appuser")
@Table(name = "appuser")
@Inheritance(strategy = InheritanceType.JOINED)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User {

    @Id
    @SequenceGenerator(name = "appuser_uid_seq",
            sequenceName = "appuser_uid_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "appuser_uid_seq")
    @Column(name = "uid", updatable = false)
    private long id;

    @Column(name = "uusrname")
    private String username;

    @Column(name = "upword")
    private String password;

    @Column(name = "uname")
    private String name;

    @Column(name = "usname")
    private String surname;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "iid", referencedColumnName = "iid")
    private Institution institution;

    @Enumerated(EnumType.STRING)
    @Column(name = "utype")
    private UserType userType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "eid", referencedColumnName = "eid")
    private Education education;

    @Version
    private int version;

    public User() {}

    public User(String username, String password, String name, String surname, Institution institution, UserType userType, Education education, int version) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.institution = institution;
        this.userType = userType;
        this.education = education;
        this.version = version;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Institution getInstitution() {
        return institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
