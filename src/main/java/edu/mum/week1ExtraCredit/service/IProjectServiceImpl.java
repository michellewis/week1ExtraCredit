package edu.mum.week1ExtraCredit.service;

import edu.mum.week1ExtraCredit.DAO.IProjectDao;
import edu.mum.week1ExtraCredit.DAO.ProjectDaoFactory;
import edu.mum.week1ExtraCredit.domain.Project;
import edu.mum.week1ExtraCredit.domain.ResourceType;
import edu.mum.week1ExtraCredit.domain.Task;
import edu.mum.week1ExtraCredit.exception.DaoException;

import java.util.List;

public class IProjectServiceImpl implements IProjectService {
    private  IProjectDao iProjectDao;
     IProjectServiceImpl() {
         iProjectDao= ProjectDaoFactory.getProjectDAO();
    }

    @Override
    public Project insert(Project project) throws DaoException {
        return iProjectDao.insert(project);
    }

    @Override
    public Project update(Project pro) throws DaoException {
        return iProjectDao.update(pro);
    }

    @Override
    public Project findById(Integer id) throws DaoException {
        return iProjectDao.findById(id);
    }

    @Override
    public List<Project> findByStatus(Boolean status) throws DaoException {
        return iProjectDao.findByStatus(status);
    }

    @Override
    public List<Task> findTasks(Project project) throws DaoException {
        return iProjectDao.findTasks(project);
    }

    @Override
    public List<Project> findByTypeOfResource(ResourceType resourceType) throws DaoException {
        return iProjectDao.findByTypeOfResource(resourceType);
    }

    @Override
    public List<Project> findByKeyWork(String keyWord) throws DaoException {
        return iProjectDao.findByKeyWork(keyWord);
    }

    @Override
    public List<Project> findProjectWithVolunteers() throws DaoException {
        return iProjectDao.findProjectWithVolunteers();
    }
}
