package edu.mum.week1ExtraCredit.service;

public class ProjectServiceFactory {

    public static  IProjectService getProjectService(){
        return new IProjectServiceImpl();
    }
}
