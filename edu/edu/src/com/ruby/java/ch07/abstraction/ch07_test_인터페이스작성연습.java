package com.ruby.java.ch07.abstraction;
/*
 * 7장 실습 코드로 구현한다 
 */

interface Shape {
	public double perimeter();  //둘레
	public float area();		//넓이
}

//삼각형
class Triangle implements Shape {
	private int x1,y1,x2,y2,x3,y3;
	@Override
	public double perimeter() { //구글링으로 계산식 찾아서 구현 
		double sum = 0;
		return sum;}
	@Override
	public float area() {
		System.out.println();
	}
}

//직사각형
class Rectangle implements Shape {
	int x1,y1,x2,y2, x3, y3, x4, y4;
	
	public Rectangle(int x1,int y1,int x2,int y2, int x3, int y3, int x4, int y4) {
		this.x1 = x1;		this.y1 = y1;
		this.x2 = x2;		this.y2 = y2;
		this.x3 = x3;		this.y3 = y3;
		this.x4 = x4;		this.y4 = y4;
	}
	

	@Override
	public double perimeter() {
		int side1;
		int side2;
		if(x1==x2) {side1 = Math.abs(x1-x3);}
		else {side1 = Math.abs(x1-x2);}
		if(y1==y2) {side2 = Math.abs(y1-y3);}
		else {side2 = Math.abs(y1-y2);}	
		return (side1+side2)*2;
	}

	@Override
	public float area() {
		int side1;
		int side2;
		if(x1==x2) {side1 = Math.abs(x1-x3);}
		else {side1 = Math.abs(x1-x2);}
		if(y1==y2) {side2 = Math.abs(y1-y3);}
		else {side2 = Math.abs(y1-y2);}	
		return(side1 * side2);
	}
}

//정사각형 - 직사각형 상속
class Square extends Rectangle {
	int side;
	public Square(int x1, int y1,int x2, int y2, int x3, int y3, int x4, int y4, int side) { 	// 생성자
		super(x1, y1, x2, y2, x3, y3, x4, y4);
		this.side = side;
	}
	
	public double perimeter() {
		return 4*side;
	}
	
	public float area() {
		return side*side;
	}


}



public class ch07_test_인터페이스작성연습 {
	public static void main(String[] args) {
//	Shape t = new Triangle(1,2,3,4,5,6);
	Shape r = new Rectangle(1,2,3,2,1,5,3,5);
	Shape s = new Square(1,2,3,2,1,5,3,5,3);
//	System.out.println("삼각형 둘레 길이 = " + t.perimeter());
//	System.out.println("삼각형 면적 = " + t.area());
	System.out.println("직사각형 둘레 길이 = " + r.perimeter());
	System.out.println("직사각형 면적 = " + r.area());
	System.out.println("정사각형 둘레 길이 = " + s.perimeter());
	System.out.println("정사각형 면적 = " + s.area());
	}
}
