import java.io.IOException;
import java.util.ArrayList;

public class CalculateSalary {

	public void calculateSalary(ArrayList<SalesTeam> team) throws IOException {
		for (int i = 0; i < team.size(); i++) {
			if (team.get(i).getJobPosition() == JobPosition.SALES_OFFICER) {
				System.out.println(team.get(i).getName() + " " + calculateSalesOfficerSalary(team.get(i)));
			} else {
				if (team.get(i).getJobPosition() == JobPosition.MANAGER) {
					System.out.println(team.get(i).getName() + " " + calculateManagerSaleSalary(team.get(i)));
				} else {
					if (team.get(i).getJobPosition() == JobPosition.SENIOR_SALES_OFFICER) {
						System.out
								.println(team.get(i).getName() + " " + calculateSeniorSalesOfficerSalary(team.get(i)));

					}
				}
			}
		}
	}

	private double calculateManagerSaleSalary(SalesTeam manager) throws IOException {
		int salary = 40;
		int postpaidSales = 30;
		int prepaidSales = 15;
		return (salary * (manager.workedHours + manager.daysOff * 8))
				+ ((postpaidSales * manager.nrOfPostpaidSales) + (prepaidSales * manager.nrOfPrepaidSales));

	}

	public double calculateSeniorSalesOfficerSalary(SalesTeam senior) throws IOException {
		int salary = 20;
		int postpaidSales = 50;
		int prepaidSales = 25;
		return (salary * (senior.workedHours + senior.daysOff * 8))
				+ ((postpaidSales * senior.nrOfPostpaidSales) + (prepaidSales * senior.nrOfPrepaidSales));

	}

	public double calculateSalesOfficerSalary(SalesTeam salesOfficer) throws IOException {

		int salary = 10;
		int postpaidSales = 25;
		int prepaidSales = 10;
		return (salary * (salesOfficer.workedHours + salesOfficer.daysOff * 8))
				+ ((postpaidSales * salesOfficer.nrOfPostpaidSales) + (prepaidSales * salesOfficer.nrOfPrepaidSales));

	}
}
