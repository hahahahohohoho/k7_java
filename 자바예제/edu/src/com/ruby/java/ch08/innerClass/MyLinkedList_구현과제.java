package com.ruby.java.ch08.innerClass;


public class MyLinkedList_구현과제 {

	private Node head; //헤드 필드
	
	public cha08_test_내부클래스구현() {
		head = null; 
	}
	
	private class Node { // 내부 클래스 생성
		private String data;
		private Node link;

		public Node(String data) {
			this.data = data;
		}
	}
	
	
	public void add(String data) {
		Node newNode = new Node(data);
		if(head ==null) {
			head = newNode;
		} else {
			Node next = head;
			while(next.link !=null) {
				next = next.link;
			}
			next.link = newNode;
		}
	}
	
	public void printList() {
		//printList() 결과는 A -> B -> C 등으로 출력한다
	}
	
	public void delete(String data) {

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
