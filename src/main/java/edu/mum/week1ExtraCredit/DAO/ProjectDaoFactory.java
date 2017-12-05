package edu.mum.week1ExtraCredit.DAO;

public class ProjectDaoFactory {

    public static IProjectDao getProjectDAO(){
        return new IProjectDaoImpl();
    }
}
