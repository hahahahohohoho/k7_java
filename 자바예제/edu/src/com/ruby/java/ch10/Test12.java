package com.ruby.java.ch10;

import java.util.TreeSet;

public class Test12 {

	public static void main(String[] args) {
		TreeSet<Integer> score = new TreeSet<Integer>();

		score.add(90);
		score.add(100);
		score.add(85);
		score.add(65);
		score.add(50);
		score.add(75);

		System.out.println(score);

		Integer value = null;

		value = score.first();
		print("가장 낮은 점수", value);
		value = score.last();
		print("가장 높은 점수", value);
		value = score.lower(85);
		print("85 바로 이전 점수", value);
		value = score.higher(85);
		print("85 바로 다음 점수", value);
		value = score.floor(85);
		print("85 또는 바로 이전 점수", value);
		value = score.ceiling(85);
		print("85 또는 바로 다음 점수", value);

		while (!score.isEmpty()) {
			value = score.pollLast();
			print("현재 가장 높은 점수", value);
		}
	}

	public static void print(String s, Integer value) {
		System.out.println(s + " : " + value);
	}
}