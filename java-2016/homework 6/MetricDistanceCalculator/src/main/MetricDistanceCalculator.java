package main;

public class MetricDistanceCalculator {

	private MetricDistanceExpressionParser parser = new MetricDistanceExpressionParser();

	public Distance computeDistance(String expression, String resultDistanceFormat) throws UnknownDistanceFormatException {
		Distance[] distanta = parser.parse(expression);
		Distance result = new Distance(resultDistanceFormat, 0);
		MetricDistanceConverter converter = new MetricDistanceConverter();
		for (Distance distance : distanta) {
			Distance converted = converter.convert(distance, resultDistanceFormat);
			result.add(converted.getValue());
		}
		return result;
	}

}
