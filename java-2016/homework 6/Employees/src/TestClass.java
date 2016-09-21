import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class TestClass {

    @Test
    public void testEmployeesWithoutParkingSpace() {
        List<Employee> employees=new ArrayList<Employee>();
        employees.add(new Employee("Andrei",13,"Senior",true));
        employees.add(new Employee("Bogdan",12,"Senior",true));
        Employee emplWithoutParking = new Employee("Dan", 1, "Junior", false);

        employees.add(emplWithoutParking);
        Set<Employee> result = new Department().getEmplyeesWithoutParkingSpace(employees);

        Assert.assertEquals(1, result.size());
        Assert.assertEquals(emplWithoutParking, result.iterator().next());
    }

    @Test
    public void testEmployeeArrangement() throws Exception {
        Employee emp1=new Employee("Andrei",13,"Senior",false);
        Employee emp2=new Employee("Bogdan",12,"Senior",false);
        Employee emp3=new Employee("Dan",1,"Junior",false);
        Employee emp4 = new Employee("Madalina",45,"Manager",false);
        Employee emp5 = new Employee("Cristi",2,"Junior",true);
        Employee emp6 = new Employee("Alex",123,"Senior",false);
        Employee emp7 = new Employee("Boby",132,"Senior",true);
        List<Employee> list = new ArrayList<Employee>();
        list.add(emp1);
        list.add(emp2);
        list.add(emp3);
        list.add(emp4);
        list.add(emp5);
        list.add(emp6);
        list.add(emp7);

        Set<Employee> result = new Department().getEmplyeesWithoutParkingSpace(list);
        Iterator<Employee> iterator = result.iterator();
        Assert.assertEquals(emp3, iterator.next());
        Assert.assertEquals(emp2, iterator.next());
        Assert.assertEquals(emp1, iterator.next());
        Assert.assertEquals(emp4, iterator.next());
        Assert.assertEquals(emp6, iterator.next());
    }

    @Test
    public void testManagement() throws Exception {
        Employee emp1=new Employee("Andrei",13,"Senior",false);
        Employee emp2=new Employee("Bogdan",12,"Senior",false);
        Employee emp3=new Employee("Dan",1,"Junior",false);
        Employee emp4 = new Employee("Madalina",45,"Manager",false);
        Employee emp5 = new Employee("Cristi",2,"Junior",true);
        Employee emp6 = new Employee("Alex",123,"Senior",false);
        Employee emp7 = new Employee("Boby",132,"Senior",true);

        List<Employee> list = new ArrayList<Employee>();
        list.add(emp1);
        list.add(emp2);
        list.add(emp3);
        list.add(emp4);
        list.add(emp5);
        list.add(emp6);
        list.add(emp7);


        Management management = new Management();
        management.ManagementEmployees(list);

        List<Employee> managerList = new ArrayList<Employee>();
        managerList.add(emp4);

        Assert.assertArrayEquals(managerList.toArray(), management.getManagerEmployee().toArray());

    }
}