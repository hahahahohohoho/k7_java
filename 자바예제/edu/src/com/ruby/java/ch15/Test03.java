package com.ruby.java.ch15;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test03 {

	public static void main(String[] args) {
		int[] score = { 50, 10, 80, 70, 90, 60, 20 };

		System.out.print("점수 목록 : ");
		IntStream.of(score).forEach((n) -> System.out.print(n + " "));
		System.out.println();

		int minVal = IntStream.of(score).min().getAsInt();
		System.out.println("최저 점수 : " + minVal);

		int maxVal = IntStream.of(score).max().getAsInt();
		System.out.println("최저 점수 : " + maxVal);

		System.out.print("점수 정렬 : ");
		IntStream stream = IntStream.of(score).sorted();
		stream.forEach((n) -> System.out.print(n + " "));
		System.out.println();

		System.out.print("낙제 점수 : ");
		IntStream failScore = IntStream.of(score).filter((n) -> n < 60);
		failScore.forEach((n) -> System.out.print(n + " "));
		System.out.println();

		int totalScore = IntStream.of(score).sum();
		System.out.println("점수 합계 : " + totalScore);

		System.out.print("5점 추가 : ");
		IntStream addScore = IntStream.of(score).map((n) -> n + 5);
		addScore.forEach((n) -> System.out.print(n + " "));
		System.out.println();

		long cnt = IntStream.of(score).count();
		System.out.println("점수 개수 : " + cnt);

		System.out.println("점수 평균 : " + totalScore / cnt);
	}

}