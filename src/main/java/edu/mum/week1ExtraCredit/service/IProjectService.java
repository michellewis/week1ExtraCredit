package edu.mum.week1ExtraCredit.service;

import edu.mum.week1ExtraCredit.domain.Project;
import edu.mum.week1ExtraCredit.domain.ResourceType;
import edu.mum.week1ExtraCredit.domain.Task;
import edu.mum.week1ExtraCredit.exception.DaoException;

import java.util.List;

public interface IProjectService {
    public Project insert(Project project) throws DaoException;

    public Project update(Project pro) throws DaoException;

    public Project findById(Integer id ) throws DaoException;

    public List<Project> findByStatus(Boolean status) throws DaoException;

    public List<Task> findTasks(Project project) throws DaoException;

    public List<Project> findByTypeOfResource(ResourceType resourceType) throws DaoException;

    public List<Project> findByKeyWork(String keyWord) throws DaoException;

    public List<Project> findProjectWithVolunteers() throws DaoException;
}
