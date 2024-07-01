package com.ruby.java.ch09;

public class Test09 {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder("날이 좋아서 ");

		System.out.println(sb);
		System.out.println(sb.append("날이 적당해서"));
		System.out.println(sb.insert(8, "날이 좋지 않아서 "));
		System.out.println(sb.append(" 모든 날이 좋았다 "));

		int start = sb.indexOf("모든 날이 좋았다 ");
		int end = sb.length();
		System.out.println(sb.replace(start, end, "너와 함께 한 시간 모두 눈부셨다"));
	}
}