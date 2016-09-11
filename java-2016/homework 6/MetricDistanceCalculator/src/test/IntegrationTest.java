package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.Distance;
import main.MetricDistanceCalculator;
import main.UnknownDistanceFormatException;

public class IntegrationTest {

	@Test
	public void expressionTest() throws UnknownDistanceFormatException {
		MetricDistanceCalculator calculator = new MetricDistanceCalculator();
		Distance result = calculator.computeDistance("12m - 72cm", "cm");
		Distance expected = new Distance("cm", 1128);
		
		assertEquals(expected, result);
	}
}
