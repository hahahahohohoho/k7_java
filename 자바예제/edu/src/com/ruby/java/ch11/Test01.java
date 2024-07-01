package com.ruby.java.ch11;

public class Test01 {

	public static void main(String[] args) {
		try {
//			int a = 1/0;
			String s = new String("java");
			int len = s.length();
			s = null;
//			s.length();
			int arr[] = new int[3];
			arr[3] = 30;
			System.out.println("OK");
		} catch(ArrayIndexOutOfBoundsException e1) {
			System.out.println(e1.getMessage());
		} catch(NullPointerException e2) {
			e2.printStackTrace();
		} catch(Exception e) {
			System.out.println("오류발생 : "+e);  //toString()이 자동으로 나옴
		}
		System.out.println("GOOD");
	}
}