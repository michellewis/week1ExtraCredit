package edu.mum.week1ExtraCredit.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Project {

    @Id
    private int id;
    @Lob
    private byte[] descriptionAndBeneficiaries;
    private String location;
    @Temporal(TemporalType.DATE)
    private Date startingDate;
    @Temporal(TemporalType.DATE)
    private Date endingDate;
    @OneToMany(mappedBy = "project")
    List<Task> tasks;



    public Project() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getDescriptionAndBeneficiaries() {
        return descriptionAndBeneficiaries;
    }

    public void setDescriptionAndBeneficiaries(byte[] descriptionAndBeneficiaries) {
        this.descriptionAndBeneficiaries = descriptionAndBeneficiaries;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(Date startingDate) {
        this.startingDate = startingDate;
    }

    public Date getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(Date endingDate) {
        this.endingDate = endingDate;
    }
}
