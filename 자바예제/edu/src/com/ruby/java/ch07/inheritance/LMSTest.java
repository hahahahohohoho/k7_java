package com.ruby.java.ch07.inheritance;

public class LMSTest {
	public static void main(String[] args) {
		Employee e = new Employee();
		Professor p = new Professor();
		Student s = new Student();

		e.setName("¿ÀÁ¤ÀÓ");
		e.setAge(47);
		e.setDept("ÀÔÇĞÃ³");

		p.setName("±èÇª¸§");
		p.setAge(52);
		p.setSubject("ºòµ¥ÀÌÅÍ");

		s.setName("±èÀ¯ºó");
		s.setAge(20);
		s.setMajor("ÄÄÇ»ÅÍ°úÇĞ");

		System.out.println(e.toString());
		System.out.println(p.toString());
		System.out.println(s.toString());
	}
}