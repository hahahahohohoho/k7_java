package com.ruby.java.ch09;

public class Test03 {
	public static void main(String[] args) {

		String s = "have a good day!";

		int length = s.length();
		System.out.println("รั ฑÛภฺ ผ๖ : " + length);
		char c;

		for (int i = 0; i < length; i++) {
			c = s.charAt(i);
			System.out.print(c);
		}
	}
}