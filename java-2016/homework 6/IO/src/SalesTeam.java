
public class SalesTeam {

	public String name;
	public JobPosition jobPosition;
	public Integer workedHours;
	public Integer daysOff;
	public Integer nrOfPrepaidSales;
	public Integer nrOfPostpaidSales;

	public SalesTeam(String name, JobPosition jobPosition, Integer workedHours, Integer daysOff,
			Integer nrOfPrepaidSales, Integer nrOfPostpaidSales) {

		this.name = name;
		this.jobPosition = jobPosition;
		this.workedHours = workedHours;
		this.daysOff = daysOff;
		this.nrOfPrepaidSales = nrOfPrepaidSales;
		this.nrOfPostpaidSales = nrOfPostpaidSales;
	}

	public SalesTeam() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public JobPosition getJobPosition() {
		return jobPosition;
	}

	public void setJobPosition(JobPosition jobPosition) {
		this.jobPosition = jobPosition;
	}

	public Integer getWorkedHours() {
		return workedHours;
	}

	public void setWorkedHours(Integer workedHours) {
		this.workedHours = workedHours;
	}

	public Integer getDaysOff() {
		return daysOff;
	}

	public void setDaysOff(Integer daysOff) {
		this.daysOff = daysOff;
	}

	public Integer getNrOfPrepaidSales() {
		return nrOfPrepaidSales;
	}

	public void setNrOfPrepaidSales(Integer nrOfPrepaidSales) {
		this.nrOfPrepaidSales = nrOfPrepaidSales;
	}

	public Integer getNrOfPostpaidSales() {
		return nrOfPostpaidSales;
	}

	public void setNrOfPostpaidSales(Integer nrOfPostpaidSales) {
		this.nrOfPostpaidSales = nrOfPostpaidSales;
	}

	@Override
	public String toString() {
		return "SalesTeam [name=" + name + ", jobPosition=" + jobPosition + ", workedHours=" + workedHours
				+ ", daysOff=" + daysOff + ", nrOfPrepaidSales=" + nrOfPrepaidSales + ", nrOfPostpaidSales="
				+ nrOfPostpaidSales + "]";
	}

}