package com.ruby.java.ch15;

import java.util.ArrayList;
import java.util.stream.Stream;

public class Test05 {

	public static void main(String[] args) {
		ArrayList<Member> members = new ArrayList<>();
		members.add(new Member("김푸름", 25, "010-123-4562", "서울"));
		members.add(new Member("김하늘", 30, "010-803-6356", "부산"));
		members.add(new Member("오정임", 29, "010-264-4872", "대전"));

		System.out.println("<<회원 정보>>");
		Stream<Member> stream = members.stream();
		stream.forEach(System.out::println);

		System.out.println("<<연락처>>");
		Stream<Contact> contactList = members.stream().map((m) -> new Contact(m.getName(), m.getPhoneNum()));
		contactList.forEach(System.out::println);

		System.out.println("<<연락처 검색>>");
		Stream<Contact> searchList = members.stream().filter((m) -> m.getName().equals("김하늘"))
				.map((m) -> new Contact(m.getName(), m.getPhoneNum()));
		searchList.forEach(System.out::println);
	}
}