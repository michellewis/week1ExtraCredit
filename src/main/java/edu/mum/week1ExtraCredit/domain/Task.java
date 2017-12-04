package edu.mum.week1ExtraCredit.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Task {
    @Id
    @GeneratedValue
    private int id;
    private boolean status;
    @Temporal(TemporalType.DATE)
    private Date startingDate;
    @Temporal(TemporalType.DATE)
    private Date endingDate;

    @ManyToOne
    @JoinColumn(name="project_id")
    Project project;
    @ElementCollection
    private List<Resource> ressources;
    @OneToMany

    private List<Volunteer> volunteers;




}
