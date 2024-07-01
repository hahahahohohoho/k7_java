package com.ruby.java.ch15;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test06 {

	public static void main(String[] args) {
		ArrayList<Double> list = new ArrayList<>();
		list.add(3.1);
		list.add(5.6);
		list.add(7.2);
		list.add(8.1);
		list.add(6.8);

		System.out.print("계산 1 : ");
		Optional<Integer> sumValue = list.stream().map((n) -> (int) Math.ceil(n)).reduce((a, b) -> a + b);
		System.out.println(sumValue.get());

		System.out.print("계산 2 : ");
		int sum = list.stream().mapToInt((n) -> (int) Math.ceil(n)).sum();
		System.out.println(sum);
	}
}