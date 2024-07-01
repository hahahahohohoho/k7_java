package com.ruby.java.ch09;

import java.text.DecimalFormat;

public class Test22 {

	public static void main(String[] args) {
		double n = 1234.23;

		DecimalFormat df1 = new DecimalFormat("0");
		System.out.println(df1.format(n)); // 1234

		DecimalFormat df2 = new DecimalFormat("0.000");
		System.out.println(df2.format(n)); // 1234.230

		DecimalFormat df3 = new DecimalFormat("#");
		System.out.println(df3.format(n)); // 1234

		DecimalFormat df4 = new DecimalFormat("#.###");
		System.out.println(df4.format(n)); // 1234.23

		DecimalFormat df5 = new DecimalFormat("#,###,###.##");
		System.out.println(df5.format(n)); // 1,234.23

		DecimalFormat df6 = new DecimalFormat("0,000,000.000");
		System.out.println(df6.format(n)); // 0,001,234.230

		DecimalFormat df7 = new DecimalFormat("+#,###;-#,###");
		System.out.println(df7.format(n)); // +1,234

		DecimalFormat df8 = new DecimalFormat("#.#%");
		System.out.println(df8.format(n)); // 123423%
	}
}