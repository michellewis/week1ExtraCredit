package edu.mum.week1ExtraCredit.application;

import edu.mum.week1ExtraCredit.domain.*;
import edu.mum.week1ExtraCredit.service.IProjectService;
import edu.mum.week1ExtraCredit.service.ProjectServiceFactory;
import edu.mum.week1ExtraCredit.util.MyFileReader;

import java.io.IOException;
import java.util.Date;

public class App {
   private static IProjectService iProjectService;
   public static  void main(String[] args) throws IOException {
       iProjectService= ProjectServiceFactory.getProjectService();
       //project
       Project pro=new Project();
       pro.setDescriptionAndBeneficiaries(new MyFileReader().fileByteArray("files/projectDescriptionAndBeneficiaries.html"));
       pro.setEndingDate(new Date());
       pro.setStartingDate(new Date());
       //Task
       Task task1=new Task();
       task1.setEndingDate(new Date());
       task1.setStartingDate(new Date());
       task1.setStatus(true);
       //resources
       Resource resource1=new Resource();
       resource1.setDescription("Human resources");
       resource1.setQuantity(7);
       resource1.setRequiredSquils("Programmer");
       resource1.setType(ResourceType.VOLUNTEER);
       task1.addResource(resource1);
       pro.addTask(task1);

       //Address
       Address addr=new Address();
       addr.setCity("Fairfield");
       addr.setState("IA");
       addr.setZip(52557);
       addr.setStreet("1000 N 4th");
       pro.setLocation(addr);

     Project managedProject=  insertProject(pro);
       System.out.println("**********************New Project Created successfully**************************");
     System.out.println("Project Id:"+managedProject.getId());
       System.out.println("Number of task in project:"+managedProject.getTasks().size());

       Task task2=new Task();
       task2.setEndingDate(new Date());
       task2.setStartingDate(new Date());
       task2.setStatus(true);
       managedProject.addTask(task2);
       //update project
       managedProject=mergeProject(managedProject);
      for(Task task:managedProject.getTasks()){
          System.out.println("**********************New Task Created successfully**************************");
          System.out.println("New Task Id:"+task.getId());
          System.out.println("Number of task in project:"+managedProject.getTasks().size());
      }

      //find the created project
       Project project=new Project();
       project.setId(managedProject.getId());
       findById(managedProject.getId());
       findByStatus(true);
       findProjectTasks(project);
       findByTypeOfResource(ResourceType.VOLUNTEER);
      // findProjectByKeyWord("2017");
       findByProjectWithVolunteer();

    }


    public static Project insertProject(Project pro ){

       return iProjectService.insert(pro);
    }
    public static Project mergeProject(Project pro ){

        return iProjectService.update(pro);
    }

    public static void findById(Integer id ){
        Project project=iProjectService.findById(id);
            System.out.println("*********Project by ID************");
            System.out.println("Id:"+project.getId());
            System.out.println("Starting Date:"+project.getStartingDate());
            System.out.println("End Date:"+project.getEndingDate());

    }
    public static void findByStatus(boolean status){
      for(Project project:iProjectService.findByStatus(status)){
          System.out.println("*********Project by status************");
          System.out.println("Id:"+project.getId());
          System.out.println("Starting Date:"+project.getStartingDate());
          System.out.println("End Date:"+project.getEndingDate());
      }
    }

    public static void findProjectTasks(Project id){
        for(Task task:iProjectService.findTasks(id)){
            System.out.println("*********Task For Project "+id.getId()+"************");
            System.out.println("Task Id:"+task.getId());
            System.out.println("Task Starting Date:"+task.getStartingDate());
            System.out.println("Task Ending Date:"+task.getEndingDate());
        }
    }

    public static void findByTypeOfResource(ResourceType resourceType){
        for(Project project:iProjectService.findByTypeOfResource(resourceType)){
            System.out.println("*********LIST OF PROJECT BY TYPE OF RESOURCE************");
            System.out.println("Project Id:"+project.getId());
            System.out.println("Project Starting Date:"+project.getStartingDate());
            System.out.println("Project Ending Date:"+project.getEndingDate());
        }
    }

    public static void findProjectByKeyWord(String keyWord){
        for(Project project:iProjectService.findByKeyWork(keyWord)){
            System.out.println("*********PROJECT BY KEY WORD************");
            System.out.println("Id:"+project.getId());
            System.out.println("Starting Date:"+project.getStartingDate());
            System.out.println("End Date:"+project.getEndingDate());
        }
    }

    public static void findByProjectWithVolunteer(){
        for(Project project:iProjectService.findProjectWithVolunteers()){
            System.out.println("*********LIST OF PROJECT WITH VOLUNTEERS************");
            System.out.println("Project Id:"+project.getId());
            System.out.println("Project Starting Date:"+project.getStartingDate());
            System.out.println("Project Ending Date:"+project.getEndingDate());
        }
    }


}
