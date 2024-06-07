package com.ruby.java.ch06;

public class StaticBlockTest {
	static {
		System.out.println("hello");
		System.out.println("java");
	}

	public static void main(String[] args) {
		System.out.println("world!!");
	}
}