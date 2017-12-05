package edu.mum.week1ExtraCredit.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Entity
public class Task implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;
    private boolean status;
    @Temporal(TemporalType.DATE)
    private Date startingDate;
    @Temporal(TemporalType.DATE)
    private Date endingDate;

    @ManyToOne
    @JoinColumn(name="project_id")
    Project project;
    @ElementCollection
    private List<Resource> resources;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name="TASK_VOLUNTEER", joinColumns = @JoinColumn(name="task_id"),inverseJoinColumns = @JoinColumn(name="volunteer_id"))
    private List<Volunteer> volunteers;

    public Task() {
        volunteers=new ArrayList<>();
        resources=new ArrayList<>();
    }
    public void addVolunteer(Volunteer vol){
        vol.assignTask(this);
        volunteers.add(vol);
    }
    public Volunteer removeVolunteer(Volunteer vol){
        volunteers.remove(vol);
        vol.unassignTask(this);
        return vol;
    }
    public void addResource(Resource resource){
        resources.add(resource);
    }
    public Resource removeResource(Resource resource){
        resources.remove(resource);
        return resource;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
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

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public List<Resource> getResources() {
        return Collections.unmodifiableList(resources);
    }

    public List<Volunteer> getVolunteers() {
        return Collections.unmodifiableList(volunteers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        return id.equals(task.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
