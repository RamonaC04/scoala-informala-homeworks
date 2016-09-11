package test;

import org.junit.Test;

import main.Distance;
import main.MetricDistanceExpressionParser;
import main.UnknownDistanceFormatException;

import static org.junit.Assert.*;

public class ParserTest {
	
	@Test
	public void testSimpleMetersParse() throws UnknownDistanceFormatException {
		MetricDistanceExpressionParser parser = new MetricDistanceExpressionParser();
		Distance[] result = parser.parse("1m");
		Distance[] expected = {new Distance("m", 1)};
		
		assertArrayEquals(expected, result);	
	}
	
	@Test
	public void testSimpleInchParse() throws UnknownDistanceFormatException {
		MetricDistanceExpressionParser parser = new MetricDistanceExpressionParser();
		Distance[] result = parser.parse("22in");
		Distance[] expected = {new Distance("in", 22)};
		
		assertArrayEquals(expected, result);	
	}

	@Test
	public void testComplexParse() throws UnknownDistanceFormatException {
		MetricDistanceExpressionParser parser = new MetricDistanceExpressionParser();
		Distance[] result = parser.parse("1m + 22cm - 12dm + 73ft");
		Distance[] expected = {new Distance("m", 1), new Distance("cm", 22), new Distance("dm", -12), new Distance("ft", 73)};
		
		assertArrayEquals(expected, result);	
	}
	
	@Test
 	public void nextOperatorTest1() {
 		MetricDistanceExpressionParser parser = new MetricDistanceExpressionParser();
 		String s = "123-";
 		assertEquals(3, parser.nextOperand(s));
 	}
 
 	@Test
 	public void nextOpPosNotFound() {
 		MetricDistanceExpressionParser parser = new MetricDistanceExpressionParser();
 	String s = "123";
 	assertEquals(-1, parser.nextOperand(s));
 }
 
 	@Test
 	public void nextOperatorTestCorrectWithMultipleOps() {
 		MetricDistanceExpressionParser parser = new MetricDistanceExpressionParser();
 		String s = "123-+-";
 		assertEquals(3, parser.nextOperand(s));
 	}
 
 	@Test
 	public void nextOperatorTestWithJustOp() {
 		MetricDistanceExpressionParser parser = new MetricDistanceExpressionParser();
 		String s = "+";
 		assertEquals(0, parser.nextOperand(s));
 	}
 
 	@Test
 	public void correctFormatIsParsed() throws UnknownDistanceFormatException {
 		MetricDistanceExpressionParser parser = new MetricDistanceExpressionParser();
 		String s = "1km+1km";
 		Distance[] expected = new Distance[] { new Distance(Distance.KILO_METERS, 1), new Distance(Distance.KILO_METERS, 1) };
 		Distance[] actual = parser.parse(s);
 		assertArrayEquals(expected, actual);
 	}
 

	@Test
 	public void correctFormatWithMinusIsParsed() throws UnknownDistanceFormatException {
 		MetricDistanceExpressionParser parser = new MetricDistanceExpressionParser();
 		String s = "1km-1dm";
 		Distance[] expected = new Distance[] { new Distance(Distance.KILO_METERS, 1), new Distance(Distance.DECI_METERS, -1) };
 		Distance[] actual = parser.parse(s);
 		assertArrayEquals(expected, actual);
 	}
 
 	@Test
 	public void correctFormatIsParsed2() throws UnknownDistanceFormatException {
 		MetricDistanceExpressionParser parser = new MetricDistanceExpressionParser();
 		String s = "1in-1.2km";
 		Distance[] expected = new Distance[] { new Distance(Distance.INCH, 1), new Distance(Distance.KILO_METERS, -1.2) };
 		Distance[] actual = parser.parse(s);
 		assertArrayEquals(expected, actual);
 	}
 
 	@Test
 	public void correctFormatWithMultipleOpsAndNegativeSignAtStartIsParsed() throws UnknownDistanceFormatException {
 		MetricDistanceExpressionParser parser = new MetricDistanceExpressionParser();
 		String s = "-12km+51dm-3.5ft";
 		Distance[] expected = new Distance[] { new Distance(Distance.KILO_METERS, -12), new Distance(Distance.DECI_METERS, 51),
 				new Distance(Distance.FOOT, -3.5) };
 		Distance[] actual = parser.parse(s);
 		assertArrayEquals(expected, actual);
 	}
 	
 	@Test
 	public void correctFormatWithMultipleOpsIsParsed() throws UnknownDistanceFormatException {
		MetricDistanceExpressionParser parser = new MetricDistanceExpressionParser();
 		String s = "11km+5miles-3.9ft";
 		Distance[] expected = new Distance[] { new Distance(Distance.KILO_METERS, 11), new Distance(Distance.MILES, 5),
 				new Distance(Distance.FOOT, -3.9) };
 		Distance[] actual = parser.parse(s);
 		assertArrayEquals(expected, actual);
 	}
 	
 	@Test(expected=UnknownDistanceFormatException.class)
 	public void parsingFailsWithInvalidDistanceFormat() throws UnknownDistanceFormatException {
 		MetricDistanceExpressionParser parser = new MetricDistanceExpressionParser();
 		String s = "-13km+54dm-2.3mii";
 		parser.parse(s);
 	}
}
