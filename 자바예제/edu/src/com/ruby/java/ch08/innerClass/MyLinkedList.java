package com.ruby.java.ch08.innerClass;

public class MyLinkedList {

	private Node head = null;
	private Node tail = null;

	private class Node {
		private String data;
		private Node link;

		public Node(String data) {
			this.data = data;
		}
	}

	public void add(String data) { //add 메서드 수행 시 문자열을 비교하여 오름차순으로 입력한다.
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
		} else {
			Node p = head;
			if (p.data.compareTo(data)> 0) { // 넣는 문자열과 head에 있는 문자열을 비교한다.
				
			}
			Node next = head;
			while (next.link != null) {
				next = next.link;
			}
			next.link = newNode;
		}
	}

	public void print() {
		if (head == null) {
			System.out.println("등록된 데이터가 없습니다.");
		} else {
			System.out.println("등록된 데이터는 다음과 같습니다.");
			Node next = head;
			while (next != null) {
				System.out.println(next.data);
				next = next.link;
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		cha08_test_내부클래스구현 myList = new cha08_test_내부클래스구현();
		myList.printList();

		myList.add("JAVA");
		myList.add("HTML");
		myList.add("CSS");
		myList.add("Javascript");
		myList.printList();
		myList.delete("CSS");
		myList.printList();
	}
}