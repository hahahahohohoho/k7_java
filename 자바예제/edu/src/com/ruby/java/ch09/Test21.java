package com.ruby.java.ch09;

import java.text.MessageFormat;

public class Test21 {

	public static void main(String[] args) {
		String s = "Member {0} orders {1} items";
		String name = "Amy";
		int item = 5;
		Object data[] = { name, item };
		String msg = MessageFormat.format(s, data);
		System.out.println(msg);
		String msg2 = MessageFormat.format(s, "Purum", 12);
		System.out.println(msg2);
	}

}