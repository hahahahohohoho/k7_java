package com.ruby.java.ch14;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.Supplier;

public class Test17 {

	public static void main(String[] args) {
		Supplier<String> day = () -> new SimpleDateFormat("Eø‰¿œ").format(new Date());
		String result = day.get();
		System.out.println(result);
	}
}