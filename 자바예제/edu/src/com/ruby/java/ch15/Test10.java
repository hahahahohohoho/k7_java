package com.ruby.java.ch15;

import java.util.ArrayList;
import java.util.Spliterator;
import java.util.stream.Stream;

public class Test10 {

	public static void main(String[] args) {
		ArrayList<String> names = new ArrayList<>();
		names.add("one");
		names.add("two");
		names.add("three");
		names.add("four");
		names.add("five");
		names.add("six");

		Stream<String> stream1 = names.stream();
		Spliterator<String> siter1 = stream1.spliterator();
		while (siter1.tryAdvance((n) -> System.out.print(n + " ")))
			;
		System.out.println();

		Stream<String> stream2 = names.stream();
		Spliterator<String> siter2 = stream2.spliterator();
		Spliterator<String> siter3 = siter2.trySplit();

		if (siter3 != null)
			siter3.forEachRemaining((n) -> System.out.print(n + " "));

		System.out.println();

		siter2.forEachRemaining((n) -> System.out.print(n + " "));
	}
}