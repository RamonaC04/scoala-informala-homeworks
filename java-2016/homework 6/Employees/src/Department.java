import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Department{


	public Set<Employee> getEmplyeesWithoutParkingSpace(List<Employee> employees) {
		Set<Employee> treeSet = new TreeSet<Employee>(new Comparator<Employee>(){

			@Override
			public int compare(Employee o1, Employee o2) {
				return o1.seniority.compareTo(o2.seniority);
			}
		});
		for (int i=0; i<employees.size();i++){
			if (!employees.get(i).hasParking) {
				treeSet.add(employees.get(i));
			}
		}
		return treeSet;
	}

	 public static void main(String[] args) {
	        
	        List<Employee> employees=new ArrayList<Employee>();
	        employees.add(new Employee("Andrei",13,"Senior",true));
	        employees.add(new Employee("Bogdan",12,"Senior",true));
	        employees.add(new Employee("Dan",1,"Junior",false));
	        employees.add(new Employee("Madalina",45,"Manager",false));
	        employees.add(new Employee("Cristi",2,"Junior",true));
	        employees.add(new Employee("Alex",12,"Senior",false));
	        employees.add(new Employee("Boby",13,"Senior",true));

		 Set<Employee> treeSet = new Department().getEmplyeesWithoutParkingSpace(employees);

		 Employee emp1=new Employee("Andrei",13,"Senior",true);
	        Employee emp2=new Employee("Bogdan",12,"Senior",true);
	        Employee emp3=new Employee("Dan",1,"Junior",false);
	        Employee emp4 = new Employee("Madalina",45,"Manager",false);
	        Employee emp5 = new Employee("Cristi",2,"Junior",true);
	        Employee emp6 = new Employee("Alex",123,"Senior",false);
	        Employee emp7 = new Employee("Boby",132,"Senior",true);
	        
	     
	        
    

      System.out.println("Employees without parking space : "+treeSet);
}
}