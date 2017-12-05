import edu.mum.week1ExtraCredit.domain.*;
import edu.mum.week1ExtraCredit.service.IProjectService;
import edu.mum.week1ExtraCredit.service.ProjectServiceFactory;
import edu.mum.week1ExtraCredit.util.MyFileReader;
import junit.framework.TestCase;
import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Date;

public class IProjectServiceImplTest  {
    private static IProjectService iProjectService;
  @BeforeClass
    public static void setUp(){
        iProjectService= ProjectServiceFactory.getProjectService();
    }

    @Test
    public final void insertTest( ) {
        Project pro=new Project();
        try {
            pro.setDescriptionAndBeneficiaries(MyFileReader.fileByteArray("C:\\Users\\DELL\\Pictures\\test.PNG"));
        }catch (Exception ex){
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
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
        Project createdProject=iProjectService.insert(pro);
        //if the project is created successfully, there should be 1 task
        assertEquals(1,createdProject.getTasks().size());

    }

    @Test
    public final void updateTest() {
        Project pro=iProjectService.findById(1);
        //Task
        Task task2=new Task();
        task2.setEndingDate(new Date());
        task2.setStartingDate(new Date());
        task2.setStatus(true);
        //resources
        Resource resource1=new Resource();
        resource1.setDescription("Truck");
        resource1.setQuantity(10);
        resource1.setRequiredSquils("");
        resource1.setType(ResourceType.ASSET);
        task2.addResource(resource1);

        pro.addTask(task2);
        iProjectService.update(pro);
        //if new task is added, new value should be two
        assertEquals(3,pro.getTasks().size());


    }
    @Test
    public final void findByIdTest( ) {

    }
    @Test
    public final void findByStatusTest() {

    }
    @Test
    public final void findTasksTest() {

    }
    @Test
    public final void findByTypeOfResourceTest() {

    }
    @Test
    public final void findByKeyWorkTest() {

    }
    @Test
    public final void findProjectWithVolunteersTest(){

    }

}
