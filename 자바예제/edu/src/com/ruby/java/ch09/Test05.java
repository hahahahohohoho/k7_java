package com.ruby.java.ch09;

public class Test05 {
	public static void main(String[] args) {
		String address[] = { "경기도 남양주 별내동", "서울시 영등포구 당산동", "충남 천안시 서북구", "서울시 양천구 목동", "서울시 송파구 석촌동", "전북 부안군 부안읍" };

		System.out.println("1");
		for (int i = 0; i < address.length; i++) {
			if (address[i].indexOf("서울시") != -1) {
				System.out.println(address[i]);
			}
		}
		System.out.println("2");
		for (int i = 0; i < address.length; i++) {
			if (address[i].lastIndexOf("별내동") != -1) {
				System.out.println(address[i]);
			}
		}
		System.out.println("3");
		for (int i = 0; i < address.length; i++) {
			if (address[i].startsWith("서울시")) {
				System.out.println(address[i]);
			}
		}
		System.out.println("4");
		for (int i = 0; i < address.length; i++) {
			if (address[i].endsWith("별내동")) {
				System.out.println(address[i]);
			}
		}
	}
}