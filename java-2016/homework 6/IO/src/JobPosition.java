
public enum JobPosition {
	SALES_OFFICER, SENIOR_SALES_OFFICER, MANAGER;

	public static JobPosition getJobPositionFromString(String jp) {
		for (JobPosition j : JobPosition.values()) {
			if (j.toString().equals(jp))
				return j;
		}
		return null;
	}
}
