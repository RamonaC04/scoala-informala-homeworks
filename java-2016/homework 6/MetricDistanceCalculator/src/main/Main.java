package main;

public class Main {

	public static void main(String[] args) throws UnknownDistanceFormatException {
		String d ="2.0km+300.0mm-35.0ft+0.1miles+45.2dm-100.4cm+208.4m+32.3in-26.8ft+800.9mm";
		MetricDistanceCalculator calc = new MetricDistanceCalculator();
		System.out.println(calc.computeDistance (d, Distance.METERS));

	}

}
