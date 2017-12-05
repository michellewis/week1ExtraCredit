package edu.mum.week1ExtraCredit.DAO;

import edu.mum.week1ExtraCredit.domain.Project;
import edu.mum.week1ExtraCredit.domain.ResourceType;
import edu.mum.week1ExtraCredit.domain.Task;
import edu.mum.week1ExtraCredit.exception.DaoException;
import edu.mum.week1ExtraCredit.util.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class IProjectDaoImpl implements IProjectDao {
    IProjectDaoImpl() {
    }

    public Project insert(Project project) throws DaoException {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(project);
        tx.commit();
        return project;
    }

    public Project update(Project pro) throws DaoException {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Project merge = em.merge(pro);
        tx.commit();
        return merge;
    }

    public Project findById(Integer id) throws DaoException {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        return em.find(Project.class, id);

    }

    public List<Project> findByStatus(Boolean status) throws DaoException {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        Query query = em.createQuery("select distinct p from Project p join p.tasks t where t.status=:status");
        query.setParameter("status", status);
        return query.getResultList();

    }

    public List<Task> findTasks(Project project) throws DaoException {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        Project pro = em.find(Project.class, project.getId());
        return pro.getTasks();

    }

    public List<Project> findByTypeOfResource(ResourceType resourceType) throws DaoException {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        Query query = em.createQuery("select p from Project p join p.tasks t join t.resources r where r.type=:type");
        query.setParameter("type", resourceType);
        return query.getResultList();

    }

    public List<Project> findByKeyWork(String keyWord) throws DaoException {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        Query query = em.createQuery("select p from Project p join p.location loc " +
                "join p.tasks t join t.resources r join t.volunteers vol " +
                "where p.startingDate like :keyWord or p.endingDate like :keyWord or loc.city like :keyWord " +
                "or loc.state like :keyWord or loc.street like :keyWord or loc.zip like :keyWord " +
                "or t.startingDate like :keyWord or t.endingDate like :keyWord or t.status like :keyWord " +
                "or r.type like :keyWord or r.description like :keyWord or r.quantity like :keyWord " +
                "or r.requiredSquils like :keyWord or vol.firstName like :keyWord or vol.LastName like :keyWord");
        query.setParameter("keyWord", "%" + keyWord + "%");
        return query.getResultList();

    }

    public List<Project> findProjectWithVolunteers() throws DaoException {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();

        Query query = em.createQuery("select p from Project p join p.tasks t where size(t.volunteers)>0 order by t.startingDate, t.endingDate");
        return query.getResultList();

    }
}
