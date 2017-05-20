package com.kindergartener.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * Created by Hp on 5/13/2017.
 */

@Entity
@Table
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Justification {

    @Id
    @SequenceGenerator(name = "justification_jid_seq",
            sequenceName = "justification_jid_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
        generator = "justification_jid_seq")
    @Column(name = "jid", updatable = false)
    private long id;

    @Column(name = "jtype", nullable = false)
    private JustificationType justificationType;

    @Column(name = "janotes")
    private String additionalNotes;

    public Justification() {}

    public Justification(JustificationType justificationType, String additionalNotes) {
        this.justificationType = justificationType;
        this.additionalNotes = additionalNotes;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public JustificationType getJustificationType() {
        return justificationType;
    }

    public void setJustificationType(JustificationType justificationType) {
        this.justificationType = justificationType;
    }

    public String getAdditionalNotes() {
        return additionalNotes;
    }

    public void setAdditionalNotes(String additionalNotes) {
        this.additionalNotes = additionalNotes;
    }
}
