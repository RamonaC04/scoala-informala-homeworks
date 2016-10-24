package main;

import java.util.Random;

public class RandomEnum<E extends Enum<?>> {

	private static final Random RND = new Random();
	public final E[] values;

	public RandomEnum(Class<E> token) {
		values = token.getEnumConstants();

	}

	public E random() {

		return values[RND.nextInt(values.length)];

	}

}
