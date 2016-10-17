import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

public class DataReader extends BufferedReader {

	public DataReader(Reader reader) {
		super(reader);
	}

	public ArrayList<SalesTeam> readSalesTeam() throws IOException, NrOfSalesManagersException {
		String txtLine = readLine();
		ArrayList<SalesTeam> team = new ArrayList<>();
		while (txtLine != null) {
			String[] tokens = txtLine.split("\\|");
			SalesTeam teamnew = new SalesTeam();
			teamnew.setName(tokens[0]);
			teamnew.setJobPosition(JobPosition.getJobPositionFromString(tokens[1]));
			teamnew.setWorkedHours(Integer.parseInt(tokens[2]));
			teamnew.setDaysOff(Integer.parseInt(tokens[3]));
			teamnew.setNrOfPrepaidSales(Integer.parseInt(tokens[4]));
			teamnew.setNrOfPostpaidSales(Integer.parseInt(tokens[5]));
			team.add(teamnew);

			txtLine = readLine();
		}
		calculateManagerNrOfPostpaidPrepaidSales(team);

		return team;
	}

	public void numberOfManagersPerTeam(ArrayList<SalesTeam> team) throws NrOfSalesManagersException {

		int noOfManagers = 0;
		for (int i = 0; i < team.size(); i++) {
			if (team.get(i).getJobPosition().equals(JobPosition.MANAGER)) {
				noOfManagers++;
				if (noOfManagers > 1) {
					throw new NrOfSalesManagersException();
				} else {
					if (noOfManagers < 1)
						throw new NrOfSalesManagersException();
				}
			}
		}
	}

	public void calculateManagerNrOfPostpaidPrepaidSales(ArrayList<SalesTeam> team) {
		int noOfPrepaidSales = 0;
		int noOfPostpaidSales = 0;
		SalesTeam man = new SalesTeam();
		for (int i = 0; i < team.size(); i++) {

			if (team.get(i).getJobPosition().equals(JobPosition.MANAGER)) {
				man = team.get(i);
			}
		}

		for (int i = 0; i < team.size(); i++) {

			noOfPostpaidSales += team.get(i).nrOfPostpaidSales;
			noOfPrepaidSales += team.get(i).nrOfPrepaidSales;
			man.setNrOfPostpaidSales(noOfPostpaidSales);
			man.setNrOfPrepaidSales(noOfPrepaidSales);
		}
	}

}
