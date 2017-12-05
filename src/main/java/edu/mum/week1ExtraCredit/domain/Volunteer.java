package edu.mum.week1ExtraCredit.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Volunteer implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;
    private String firstName;
    private String LastName;
    @ManyToMany(mappedBy = "volunteers")
    private List<Task> tasks;


    public Volunteer() {
        tasks=new ArrayList<>();
    }

    public void assignTask(Task task){
        tasks.add(task);
    }
    public Task unassignTask(Task task){
        tasks.remove(task);
     return task;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Volunteer volunteer = (Volunteer) o;

        return id.equals(volunteer.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
