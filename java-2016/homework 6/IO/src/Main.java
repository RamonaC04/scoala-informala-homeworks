import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException {

		File txt = new File("C:\\Users\\Ramona\\Desktop\\Ex acasa\\IO\\src\\Sales_team.txt");

		DataReader txtReader = new DataReader(new FileReader(txt));
		ArrayList<SalesTeam> team = null;
		try {
			team = txtReader.readSalesTeam();
		} catch (NrOfSalesManagersException e) {
			e.printStackTrace();
		}
		txtReader.close();

		CalculateSalary employee = new CalculateSalary();
		employee.calculateSalary(team);
	}

}