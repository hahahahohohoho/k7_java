package com.ruby.java.ch13;

class StringUtil {
	private String value;

	<T extends CharSequence> StringUtil(T value) {
		this.value = value.toString();
	}

	void printVal() {
		System.out.println("value: " + value);
	}
}

public class GenConsTest {

	public static void main(String[] args) {
		String s = new String("서울");
		StringBuffer sbuf = new StringBuffer("대전");
		StringBuilder sbui = new StringBuilder("대구");

		StringUtil su1 = new StringUtil(s);
		StringUtil su2 = new StringUtil(sbuf);
		StringUtil su3 = new StringUtil(sbui);

		su1.printVal();
		su2.printVal();
		su3.printVal();
	}
}