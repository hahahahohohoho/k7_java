package com.ruby.java.ch09;

public class Test04 {
	public static void main(String[] args) {
		String s = " Amy "; // Amy 앞뒤로 공백 4개가 있어요
		int len1 = s.length();

		String s2 = s.trim();
		int len2 = s2.length();

		System.out.println(len1); // 11
		System.out.println(len2); // 3

		s = "";
		System.out.println(s.length()); // 0
		System.out.println(s.isEmpty()); // true
	}
}