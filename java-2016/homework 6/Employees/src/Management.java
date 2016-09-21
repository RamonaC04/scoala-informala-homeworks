import java.util.ArrayList;
import java.util.List;

public class Management {

    private List<Employee> juniorEmployee = new ArrayList<Employee>();
    private List<Employee> seniorEmployee = new ArrayList<Employee>();
    private List<Employee> managerEmployee = new ArrayList<Employee>();

    public void ManagementEmployees(List<Employee> employee) {
        for (int i = 0; i < employee.size(); i++) {
            if (employee.get(i).rol == "Manager") {
                managerEmployee.add(employee.get(i));
            } else if (employee.get(i).rol == "Junior") {
                juniorEmployee.add(employee.get(i));
            } else if (employee.get(i).rol == "Senior") {
                seniorEmployee.add(employee.get(i));
            }

        }

    }

    public List<Employee> getJuniorEmployee() {
        return juniorEmployee;
    }

    public List<Employee> getManagerEmployee() {
        return managerEmployee;
    }

    public List<Employee> getSeniorEmployee() {
        return seniorEmployee;
    }
}

	

