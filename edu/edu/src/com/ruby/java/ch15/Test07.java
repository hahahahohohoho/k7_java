package com.ruby.java.ch15;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test07 {

	public static void main(String[] args) {
		String str = "apple,banana,peach,melon,mango,kiwi";
		Stream<String> stream1 = Stream.of(str);
		stream1.flatMap(s -> Arrays.stream(s.split(","))).forEach(s -> System.out.print(s + " "));

		System.out.println();

		String numbers = "12,10,13,18,14,16,17";
		Stream<String> stream2 = Stream.of(numbers);
		stream2.flatMapToInt(s -> {
			String[] sList = s.split(",");
			int[] nList = new int[sList.length];
			for (int i = 0; i < nList.length; i++)
				nList[i] = Integer.parseInt(sList[i]);
			return IntStream.of(nList);
		}).forEach(n -> System.out.print(n + " "));
	}
}