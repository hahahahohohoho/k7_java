package com.ruby.java.ch14;

interface MyInterface {
	public void print();
}

class MyClass1 implements MyInterface {
	@Override
	public void print() {
		System.out.println("MyClass1");
	}
}

class MyClass2 implements MyInterface {
	@Override
	public void print() {
		System.out.println("MyClass2");
	}
}

public class Test01 {
	public static void test(MyInterface mi) {
		mi.print();
	}
	public static MyInterface test2() {
		MyInterface mi = new MyInterface() {
			@Override
			public void print() {
				System.out.println("test2()메서드에서 반환된 MyInterface");
			}
		};
		return mi;
	}

	public static void main(String[] args) {
	
		MyClass1 mc1 = new MyClass1();
		MyClass2 mc2 = new MyClass2();
		mc1.print(); // MyClass1
		mc2.print(); // MyClass2
		//방법 2 : 익명클래스 사용
		MyInterface mi = new MyInterface() {
			@Override
			public void print() {
				System.out.println("익명 클래스로 구현");
			}
		};
		test(mc1); // MyClass1
		test(mi); // 익명 클래스로 구현
	
		mi.print(); // �͸� Ŭ������ ����
		//방법3 : 익명클래스 선언, 익명객체 생성, 호출을 한번에 처리(익명객체)
		(new MyInterface() {
			@Override
			public void print() {
				System.out.println("선언, 생성, 호춣을 한번에 처리");
			}
		}).print(); // ����, ����, ȣ���� �ѹ��� ó��
	
		MyInterface mi2 = test2();
		mi2.print(); // test2() �޼��忡�� ��ȯ�� MyInterface
	}
}