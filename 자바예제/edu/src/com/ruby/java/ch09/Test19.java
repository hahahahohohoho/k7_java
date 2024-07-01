package com.ruby.java.ch09;

import java.util.Arrays;

public class Test19 {

	public static void main(String[] args) {
		String title = "**** 2018 Olympic ****";
		title = title.replaceAll("\\*", "=");
		System.out.println(title);
		title = title.replaceAll("\\w+", "Winter");
		System.out.println(title);
		title = title.replaceAll("Winter", "Olympic");
		System.out.println(title);

		String str = "1, 2, 3, 4, 5, 6, 7, 8";
		String[] result = str.split(",\\s*");
		System.out.println(Arrays.toString(result));

		String temp = "-20";
		temp = temp.replaceFirst("\\W", "+");
		System.out.println(temp);
	}
}