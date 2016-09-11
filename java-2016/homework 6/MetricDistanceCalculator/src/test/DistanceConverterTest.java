package test;
import org.junit.Test;

import main.Distance;
import main.MetricDistanceConverter;
import main.UnknownDistanceFormatException;

import org.junit.Assert;

public class DistanceConverterTest {

	@Test
	public void mettersToKilomettersConvertion() throws UnknownDistanceFormatException {
		Distance m1000 = new Distance(Distance.METERS, 1000);
		MetricDistanceConverter distanceConverter = new MetricDistanceConverter();

		Distance result = distanceConverter.convert(m1000, Distance.KILO_METERS);
		Distance expected = new Distance(Distance.KILO_METERS, 1);

		Assert.assertEquals("Convertion from m to km is incorrect.", expected, result);
	}

	@Test
	public void kilomettersToMettersConvertion() throws UnknownDistanceFormatException {
		Distance km1 = new Distance(Distance.KILO_METERS, 1);
		MetricDistanceConverter distanceConverter = new MetricDistanceConverter();

		Distance result = distanceConverter.convert(km1 , Distance.METERS);
		Distance expected = new Distance(Distance.METERS, 1000);

		Assert.assertEquals("Convertion from km to m is incorrect.", expected, result);
	}
}
