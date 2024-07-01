package com.ruby.java.ch09;

import java.util.Calendar;
import java.util.Date;

public class Test17 {
	public static void main(String[] args) {
		Date d = new Date();
		System.out.println(d);

		Calendar c = Calendar.getInstance();

		System.out.println(c.get(Calendar.YEAR));
		System.out.println(c.get(Calendar.MONTH) + 1);
		System.out.println(c.get(Calendar.DAY_OF_MONTH));
		System.out.println(c.get(Calendar.HOUR));
		System.out.println(c.get(Calendar.MINUTE));

		c.clear();
		c.set(2020, 3, 19);
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);
		int day = c.get(Calendar.DAY_OF_MONTH);
		System.out.println("날짜 정보 : " + year + "/" + month + "/" + day);
	}
}