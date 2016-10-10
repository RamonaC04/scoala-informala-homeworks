package ex;

public class Main {

	public static void main(String[] args) {
		Sorter str = new Sorter();
		Integer[] B = { 10, 5, 1, 3, 2, 15, 6, 13 };
		String[] strings = { "cat ", "monkey", "dog", "rabbit", "dear" };
		Double[] C = { 2.3, 5., 7.8, 1.3, 0.3, 33. };

		str.bubbleSort(strings);
		str.bubbleSort(C);
		str.bubbleSort(B);
		str.display(strings);
		str.display(C);
		str.display(B);
	}
}