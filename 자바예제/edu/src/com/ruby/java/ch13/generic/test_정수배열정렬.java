package com.ruby.java.ch13.generic;
/*
 * 정수 배열을 정렬후 출력
 * 실수 배열을 정렬후 출력
 * 스트링 배열을 정렬후 출력하는 코드 완성 
 */
import java.util.Arrays;
import java.util.Random;

public class test_정수배열정렬 {
	static void showData(int[]data) {
		System.out.println(Arrays.toString(data));
	}
	static void showData(double[]data) {
		System.out.println(Arrays.toString(data));
	}
	static void showData(String[]data) {
		System.out.println(Arrays.toString(data));
	}

	
	
	public static void main(String[] args) {
		Random rnd = new Random();
		int [] data = new int[20];
		for (int i = 0; i < data.length; i++) {
			data[i] = rnd.nextInt(15);
		}
		double []doubleData = new double[20];
		for (int i = 0; i < data.length; i++) {
			doubleData[i] = rnd.nextDouble();
		}
		String [] stringData = {"apple","grape","blueberry","banana"};
					
		Arrays.sort(data);
		showData(data);
		Arrays.sort(doubleData);
		showData(doubleData);
		Arrays.sort(stringData);
		showData(stringData);
		//출력 
	}
}
