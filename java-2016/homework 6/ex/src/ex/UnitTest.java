package ex;

import static org.junit.Assert.*;

import org.junit.Test;

public class UnitTest {

	@Test
	public void testSortString() {

		String[] test = { "c", "a", "b", "e" };

		String[] expected = { "a", "b", "c", "e" };

		new Sorter().bubbleSort(test);

		assertArrayEquals(expected, test);

	}

	@Test

	public void testSortInteger() {

		Integer[] test2 = { 9, 2, 10, 100, 4, 5 };

		Integer[] expected2 = { 2, 4, 5, 9, 10, 100 };

		new Sorter().bubbleSort(test2);

		assertArrayEquals(expected2, test2);

	}

	@Test

	public void testSortDouble() {

		Double[] test3 = { 2.3, 4.9, 1.2, 0.8 };

		Double[] expected3 = { 0.8, 1.2, 2.3, 4.9 };

		new Sorter().bubbleSort(test3);

		assertArrayEquals(expected3, test3);

	}

	@Test
	public void testSortIepure() {
		Iepure[] iepuri = new Iepure[] { new Iepure(5), new Iepure(1), new Iepure(3) };
		Iepure[] iepuriResult = new Iepure[] { new Iepure(1), new Iepure(3), new Iepure(5) };

		new Sorter().bubbleSort(iepuri);

		assertArrayEquals(iepuriResult, iepuri);
	}

	@Test
	public void testSortDay() {
		WeekDay[] days = new WeekDay[] { new WeekDay("marti"), new WeekDay("joi"), new WeekDay("luni"),
				new WeekDay("miercuri") };
		WeekDay[] daysResult = new WeekDay[] { new WeekDay("luni"), new WeekDay("marti"), new WeekDay("miercuri"),
				new WeekDay("joi") };

		new Sorter().bubbleSort(days);

		assertArrayEquals(daysResult, days);

	}
}