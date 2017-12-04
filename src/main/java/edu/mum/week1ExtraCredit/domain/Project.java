package edu.mum.week1ExtraCredit.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Entity
public class Project {

    @Id
    @GeneratedValue
    private Integer id;
    @Lob
    @Basic(optional = false)
    private byte[] descriptionAndBeneficiaries;
    private Address location;
    @Temporal(TemporalType.DATE)
    private Date startingDate;
    @Temporal(TemporalType.DATE)
    private Date endingDate;
    @OneToMany(mappedBy = "project",cascade = CascadeType.ALL)
    List<Task> tasks;

    public void addTask(Task task){
        task.setProject(this);
        tasks.add(task);
    }
    public Task removeTask(Task task){
        tasks.remove(task);
        task.setProject(null);
        return task;
    }


    public Project() {
        tasks=new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public byte[] getDescriptionAndBeneficiaries() {
        return descriptionAndBeneficiaries;
    }

    public void setDescriptionAndBeneficiaries(byte[] descriptionAndBeneficiaries) {
        this.descriptionAndBeneficiaries = descriptionAndBeneficiaries;
    }

    public Address getLocation() {
        return location;
    }

    public void setLocation(Address location) {
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

    public List<Task> getTasks() {
        return Collections.unmodifiableList(tasks);
    }


}
