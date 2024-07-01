package com.ruby.java.ch10;

import java.util.ArrayList;
import java.util.Iterator;

public class Test02 {

	public static void main(String[] args) {

		ArrayList<String> list = new ArrayList<String>();
		list.add("¼­¿ï");
		list.add("ºÏ°æ");
		list.add("»óÇØ");
		list.add("¼­¿ï");
		list.add("µµÄì");
		list.add("´º¿å");

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

		System.out.println("==============");

		Iterator<String> iter = list.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
}