package com.ruby.java.ch15;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test08 {

	public static void main(String[] args) {
		ArrayList<Member> members = new ArrayList<>();
		members.add(new Member("±Ë«™∏ß", 25, "010-123-4562", "º≠øÔ"));
		members.add(new Member("±Ë«œ¥√", 30, "010-803-6356", "∫ŒªÍ"));
		members.add(new Member("ø¿¡§¿”", 29, "010-264-4872", "¥Î¿¸"));

		System.out.println("<< List >>");
		Stream<Contact> stream = members.stream().map((m) -> new Contact(m.getName(), m.getPhoneNum()));
		List<Contact> list = stream.collect(Collectors.toList());
		for (Contact c : list)
			System.out.println(c);

		System.out.println("<< Set >>");
		stream = members.stream().map((m) -> new Contact(m.getName(), m.getPhoneNum()));
		Set<Contact> set = stream.collect(Collectors.toSet());
		for (Contact c : set)
			System.out.println(c);

		System.out.println("<< Map >>");
		stream = members.stream().map((m) -> new Contact(m.getName(), m.getPhoneNum()));
		Map<String, String> map = stream.collect(Collectors.toMap(m -> m.getPhoneNum(), m -> m.getName()));
		for (String key : map.keySet())
			System.out.println(key + " " + map.get(key));

		System.out.println("<< LindedList >>");
		stream = members.stream().map((m) -> new Contact(m.getName(), m.getPhoneNum()));
		LinkedList<Contact> list2 = stream.collect(Collectors.toCollection(LinkedList::new));
		for (Contact c : list2)
			System.out.println(c);
	}
}