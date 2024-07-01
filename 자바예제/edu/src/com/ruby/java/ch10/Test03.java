package com.ruby.java.ch10;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class Test03 {

	public static void main(String[] args) {

		Vector<String> vector = new Vector<String>(20);

		vector.addElement("¼­¿ï");
		vector.addElement("µµÄì");
		vector.addElement("´º¿å");

		for (int i = 0; i < vector.size(); i++) {
			System.out.print(vector.elementAt(i) + "\t");
		}

		System.out.println("\n");

		System.out.println("1 : " + vector.firstElement());
		System.out.println("2 : " + vector.lastElement());

		vector.insertElementAt("ÆÄ¸®", 2);
		print(3, vector);
		vector.setElementAt("·±´ø", 1);
		print(4, vector);

		System.out.println("3 : " + vector.capacity());
		System.out.println("4 : " + vector.size());
		vector.trimToSize();
		System.out.println("5 : " + vector.capacity());

		vector.removeElement("´º¿å");
		print(6, vector);
		vector.removeElementAt(1);
		print(7, vector);
		vector.removeAllElements();
		print(8, vector);

		List<String> list = Arrays.asList("¼­¿ï", "µµÄì", "´º¿å");
		vector.addAll(list);
		print(9, vector);
		vector.setSize(6);
		print(10, vector);

	}

	public static void print(int n, List<String> vector) {
		System.out.println(n + " : " + vector);
	}
}