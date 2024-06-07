package com.ruby.java.ch09;

public class Test11 {

	public static void main(String[] args) {
		boolean bool = true;
		byte b = 12;
		char c = 'A';
		double d = 3.14;
		float f = 10.5f;
		int i = 123;
		long l = 123456789;
		short s = 256;

		Boolean obj1 = Boolean.valueOf(bool);
		Byte obj2 = Byte.valueOf(b);
		Character obj3 = Character.valueOf(c);
		Double obj4 = Double.valueOf(d);
		Float obj5 = Float.valueOf(f);
		Integer obj6 = Integer.valueOf(i);
		Long obj7 = Long.valueOf(l);
		Short obj8 = Short.valueOf(s);

		boolean bool2 = obj1.booleanValue();
		byte b2 = obj2.byteValue();
		char c2 = obj3.charValue();
		double d2 = obj4.doubleValue();
		float f2 = obj5.floatValue();
		int i2 = obj6.intValue();
		long l2 = obj7.longValue();
		short s2 = obj8.shortValue();
	}
}