package com.ruby.java.ch08;

enum Mandarin {
	금귤, 한라봉, 레드향, 천혜향, 황금향
}

public class EnumTest02{
	public static void main(String[] args) {
		
		Mandarin ma = Mandarin.한라봉;  //위치를 0부터 시작
		
		System.out.println("이름 : " + ma.name());
		System.out.println("위치 : " + ma.ordinal());
		System.out.println("황금향과의 상대위치 : " + ma.compareTo(Mandarin.황금향));
		
		Mandarin ma2 = Mandarin.valueOf("레드향");
		System.out.println(ma2);
		
		Mandarin list[] = Mandarin.values();
		System.out.println("== 귤의 종류 ==");
		for(Mandarin m : list)
			System.out.println(m);
		
	}
} 