
package ex;

public class Sorter {

	public <T extends Comparable<T>> T[] bubbleSort(T[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = 0; j < (a.length - i - 1); j++) {
				if (a[j].compareTo(a[j + 1]) > 0) {
					T k = a[j];
					a[j] = a[j + 1];
					a[j + 1] = k;
				}
			}
		}
		return a;
	}

	public <T> void display(T[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

}
