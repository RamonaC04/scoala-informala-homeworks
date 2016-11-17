package Main;

public class PackageProfitCalculator {
	private final Integer valuePerKm;

	public PackageProfitCalculator(Integer valuePerKm) {

		this.valuePerKm = valuePerKm;
	}

	public double calculateProfit(Package packages) {

		return (valuePerKm * packages.getDistanceInKmToTheTarget());

	}
}
