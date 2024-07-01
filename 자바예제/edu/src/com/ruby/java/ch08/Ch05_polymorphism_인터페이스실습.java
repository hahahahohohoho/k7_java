package com.ruby.java.ch08;

interface Shape {
	public double perimeter();
	public float area();
	@Override
	String toString(); //7장 과제랑 다른점
}

class Triangle implements Shape {
	private int x1,y1,x2,y2,x3,y3;
	public Triangle(int x1, int y1, int x2, int y2, int x3, int y3) {
		this.x1 = x1;		this.y1 = y1;		this.x2 = x2;		this.y2 = y2;
		this.x3 = x3;		this.y3 = y3;
	}
	@Override
	public double perimeter() { //구글링으로 계산식 찾아서 구현
		double sum = 0;
		return sum;}
	@Override
	public float area() {
		return 0;
	}
	
	public String toString() {
		return "삼각형"+"("+ x1 + "," + y1 + ")"	+ "("+ x2 + "," + y2 + ")" + "("+ x3 + "," + y3 + ")";		
	}
}


class Rectangle implements Shape {
	int x1,y1,x2,y2,x3,y3,x4,y4;
	public Rectangle(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
		this.x1 = x1;		this.y1 = y1;		this.x2 = x2;		this.y2 = y2;
		this.x3 = x3;		this.y3 = y3;		this.x4 = x4;		this.y4 = y4;
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
	public String toString() {
		return "사각형"+ "("+ x1 + "," + y1 + ")"	+ "("+ x2 + "," + y2 + ")" + "("+ x3 + "," + y3 + ")"+ "("+ x4 + "," + y4 + ")";		
	}
}

class Square extends Rectangle {
	int side;
	public Square(int x1, int y1,int x2, int y2, int x3, int y3, int x4, int y4, int side) { 
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


class Pentagon implements Shape {
	private int x1,y1,x2,y2,x3,y3,x4,y4,x5,y5;
	public Pentagon(int x1, int y1,int x2, int y2, int x3, int y3, int x4, int y4, int x5, int y5) {
		this.x1 = x1;		this.y1 = y1;		this.x2 = x2;		this.y2 = y2;
		this.x3 = x3;		this.y3 = y3;		this.x4 = x4;		this.y4 = y4;
		this.x5 = x5;		this.y5 = y5;
	}
	@Override
	public double perimeter() {
		return 0;
	}
	@Override
	public float area() {
		return 0;
	}
	public String toString() {
		return "오각형"+"("+ x1 + "," + y1 + ")"	+ "("+ x2 + "," + y2 + ")" + "("+ x3 + "," + y3 + ")"+ "("+ x4 + "," + y4 + ")"+ "("+ x5 + "," + y5 + ")";		
	}
}


public class Ch05_polymorphism_인터페이스실습 {
	public static void main(String[] args) {
	
		Shape[]arr = new Shape[4];
		arr[0] = new Triangle(1,2,3,4,5,6);
		arr[1] = new Rectangle(1,2,3,2, 1,5,3,5);
		arr[2] = new Square(1,2,3,2,1,4,3,4,2);
		arr[3] = new Pentagon(5,1, 8,1,3,5,10,5,6,12);
		for(Object p : arr) {
			System.out.println(p.toString());
			System.out.println("perimeter : "+((Shape) p).perimeter() + "  area : "+((Shape) p).area());
		}
//		System.out.println("삼각형 둘레 길이 = " + p.perimeter());
//		System.out.println("삼각형 면적 = " + t.area());
//		System.out.println("사각형 둘레 길이 = " + r.perimeter());
//		System.out.println("사각형 면적 = " + r.area());
	}
}

