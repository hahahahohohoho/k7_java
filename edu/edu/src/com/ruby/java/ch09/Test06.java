package com.ruby.java.ch09;

public class Test06 {

	public static void main(String[] args) {
		String s = "Everything in your world is created";

		String s2 = s.concat(" by what you think.");

		System.out.println(s2);

		String s3 = s2.replaceAll("by what you think.", "by your thoughts.");

		System.out.println(s3);

		String s4 = s3.toLowerCase();
		String s5 = s3.toUpperCase();

		System.out.println(s4);
		System.out.println(s5);

	}

}